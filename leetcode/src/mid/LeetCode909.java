package mid;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Auther: kep
 * @Date: 2023/8/16 23:03
 * @Description:
 */
public class LeetCode909 {
    public int snakesAndLadders(int[][] board) {
        boolean[][] vis = new boolean[board.length * board.length +1][board.length * board.length +1];
        Queue<Integer> q = new LinkedList<>();
        vis[board.length-1][0] = true;
        q.add(1);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int tmp = q.poll();
                for (int step = 1; step <= 6; step++) {
                    if (tmp + step > board.length * board.length || vis[tmp][tmp + step]) {
                        continue;
                    }
                    int tmpX = getTmpX(tmp + step, board.length);
                    int tmpY = getTmpY(tmp + step, board.length);
                    if (board[tmpX][tmpY] > 0) {
                        if (vis[tmp][board[tmpX][tmpY]]) {
                            continue;
                        }
                        vis[tmp][board[tmpX][tmpY]] = true;
                        q.add(board[tmpX][tmpY]);
                        if(board[tmpX][tmpY] == board.length * board.length){
                            return level + 1;
                        }
                    } else {
                        vis[tmp][tmp + step] = true;
                        q.add(tmp + step);
                        if(tmp + step == board.length * board.length){
                            return level + 1;
                        }
                    }
                }
            }
            if(level == -1){
                level = 1;
            }else{
                level++;
            }
        }
        return -1;
    }

    private int getTmpX(int num,int length){
        return length - (num/length + (num%length == 0?0:1));
    }

    private int getTmpY(int num,int length){
        int level = (num-1)/length;
        int offSet = (num-1)%length;
        if(level % 2 == 0){
            return offSet;
        }
        return length - 1 - offSet;
    }


    public int snakesAndLadders2(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(nxt, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) { // 到达终点
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }

    public static void main(String[] args) {
        int[][] tmp = {{-1,1,2,-1},

                {2,13,15,-1},

                {-1,10,-1,-1},

                {-1,6,2,8}};
        new LeetCode909().snakesAndLadders2(tmp);
    }

}
