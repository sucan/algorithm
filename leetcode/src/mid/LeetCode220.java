package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/6 17:27
 * @Description:
 */
public class LeetCode220 {
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if('1' == grid[i][j] && !vis[i][j]){
                    vis[i][j] = true;
                    dfs(grid,i,j,vis);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid,int x,int y,boolean[][] vis){
        for(int i = 0;i<4;i++){
            int tmpX = x + dir[i][0];
            int tmpY = y + dir[i][1];
            if(tmpX <0 || tmpX >= grid.length){
                continue;
            }
            if(tmpY < 0 || tmpY >= grid[x].length){
                continue;
            }
            if(!vis[tmpX][tmpY] && '1' == grid[tmpX][tmpY]){
                vis[tmpX][tmpY] = true;
                dfs(grid,tmpX,tmpY,vis);
            }
        }
    }
}
