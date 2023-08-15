package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/13 23:05
 * @Description:
 */
public class LeetCode427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return dfs(0,0,grid.length-1,grid.length-1,grid);
    }

    private Node dfs(int x,int y,int x1,int y1,int[][] grid){
        boolean isSame = true;
        int value = grid[x][y];
        for(int i = x;i<=x1;i++){
            for(int j = y;j<=y1;j++){
                if(value != grid[i][j]){
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame){
            return new Node(value == 1,true);
        }
        return new Node(true,false,
                dfs(x,y,(x+x1)/2,(y+y1)/2,grid),
                dfs(x,(y+y1)/2,(x+x1)/2,y1,grid),
                dfs((x+x1)/2,y,x1,(y+y1)/2,grid),
                dfs((x+x1)/2,(y+y1)/2,x1,y1,grid));
    }
}
