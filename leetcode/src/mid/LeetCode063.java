package mid;

/**
 * @Auther: kep
 * @Date: 2022/4/24 21:57
 * @Description:
 */
public class LeetCode063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] != 1?1:0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i != 0 && obstacleGrid[j][i] != 1){
                    dp[j][i] += dp[j][i-1];
                }
                if(j != 0 &&  obstacleGrid[j][i] != 1){
                    dp[j][i] += dp[j-1][i];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
