package abc176;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/11 11:30 下午
 */
public class D {

    static class Node{
        int i;
        int j;
        int value;

        Node(int i,int j,int value){
            this.i = i;
            this.j =j;
            this.value =value;
        }
    }

    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    private static boolean vis[][] = new boolean[1003][1003];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int s = scanner.nextInt();
        int e= scanner.nextInt();
        int ts = scanner.nextInt();
        int te = scanner.nextInt();
        String[] map = new String[h+1];
        for(int i=1;i<=h;i++){
            map[i] =scanner.next();
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(s,e,0));
        int ans = -1;
        while(!deque.isEmpty()){
            Node node = deque.pollFirst();
            int now_i = node.i;
            int now_j = node.j;
            int now_value = node.value;
            if(now_i == ts && now_j == te){
                ans = now_value;
                break;
            }
            for(int i = 0;i<4;i++){
                int tmp_i = dir[i][0] + now_i;
                int tmp_j = dir[i][1] + now_j;
                if(tmp_i <=0 || tmp_i > h || tmp_j <=0 || tmp_j > w)continue;
                if(!vis[tmp_i][tmp_j]  && map[tmp_i].charAt(tmp_j-1) != '#') {
                    deque.addFirst(new Node(tmp_i, tmp_j, now_value));
                    vis[tmp_i][tmp_j] = true;
                }
            }
            for(int i = now_i-2;i<=now_i+2;i++){
                if(i <=0 || i > h)continue;
                for(int j = now_j-2;j<=now_j+2;j++){
                    if(j <=0 || j > w)continue;
                    if(!vis[i][j] && map[i].charAt(j-1) != '#') {
                        deque.addLast(new Node(i, j, now_value+1));
                        vis[i][j] = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
