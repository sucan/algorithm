/**
 * @Auther: kep
 * @Date: 2022/4/24 21:58
 * @Description:
 */
public class LeetCode064 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(j != 0){
                    if(dp[i][j] == 0){
                        dp[i][j] = dp[i][j-1]+grid[i][j];
                    }else{
                        dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+grid[i][j]);
                    }
                }
                if(i != 0){
                    if(dp[i][j] == 0){
                        dp[i][j] = dp[i-1][j]+grid[i][j];
                    }else{
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+grid[i][j]);
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
