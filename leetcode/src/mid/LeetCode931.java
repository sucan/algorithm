package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/3 23:32
 * @Description:
 */
public class LeetCode931 {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(i == 0){
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + matrix[i][j];
                if(j != 0 ){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+matrix[i][j]);
                }
                if(j != matrix[i].length-1){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j+1]+matrix[i][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0;j<matrix[matrix.length-1].length;j++){
            ans = Math.max(ans,dp[matrix.length-1][j]);
        }
        return ans;
    }
}
