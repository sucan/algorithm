package round660;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by enpingkuang on 2020/8/4 10:15 PM
 */
public class CaptainFlintAndTreasure {

    private static boolean[] vis = new boolean[200005];
    private static long[] a = new long[200005];
    private static int[] b = new int[200005];
    private static Vector<Integer>[] G = new Vector[200005];
    private static Vector<Integer>[] order = new Vector[2];
    private static long ans = 0;






    private static void init(int n){
        for(int i = 0;i<=n;i++){
            vis[i] = false;
            G[i] = new Vector<>(2);
        }
        order[0] = new Vector<>(100);
        order[1] = new Vector<>(100);
        ans = 0;
    }

    private static void dfs(int index){
        vis[index] = true;
        for(Integer next:G[index]){
            if(!vis[next]){
                dfs(next);
            }
        }
        ans += a[index];
        if(a[index] > 0 ){
            if(b[index] != -1) {
                a[b[index]] += a[index];
            }
            order[0].add(index);
        }else{
            order[1].add(index);
        }
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        while(t-- > 0){
            int n = scanner.nextInt();
            init(n);
            for(int i = 1;i<=n;i++){
                a[i] = scanner.nextInt();
            }
            for(int i=1;i<=n;i++){
                int tmp = scanner.nextInt();
                b[i] = tmp;
                if(tmp != -1){
                    G[tmp].addElement(i);
                }
            }
            for(int i = 1;i<=n;i++){
                if(!vis[i]){
                    dfs(i);
                }
            }
            System.out.println(ans);
            boolean flag = false;
            for(int i = 0;i<order[0].size();i++){
                if(!flag) {
                    System.out.print(order[0].get(i));
                }else{
                    System.out.print(" "+order[0].get(i));
                }
                flag = true;
            }
            for(int i = order[1].size()-1;i>=0;i--){
                if(!flag) {
                    System.out.print(order[1].get(i));
                }else{
                    System.out.print(" "+order[1].get(i));
                }
                flag = true;
            }
//        }
    }
}
