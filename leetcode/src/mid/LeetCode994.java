package mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: kep
 * @Date: 2023/8/3 22:12
 * @Description:
 */
public class LeetCode994 {
    class Node{
        int x,y;

        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        int totalCount = 0;
        int level = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Node(i,j));
                }
                if(grid[i][j] == 1){
                    totalCount++;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node node = q.poll();
                for(int j = 0;j<4;j++){
                    int tmpX = node.getX() + dir[j][0];
                    int tmpY = node.getY() + dir[j][1];
                    if(tmpX < 0 || tmpX >= grid.length || tmpY < 0 || tmpY >= grid[0].length){
                        continue;
                    }
                    if(grid[tmpX][tmpY] == 1){
                        totalCount--;
                        grid[tmpX][tmpY] = 2;
                        q.add(new Node(tmpX,tmpY));
                    }
                }
            }
            if(!q.isEmpty()) {
                level++;
            }
        }
        if(totalCount != 0){
            return -1;
        }
        return level;
    }
}
