package mid;

/**
 * @Auther: kep
 * @Date: 2022/4/23 17:06
 * @Description:
 */
public class LeetCode062 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i != 0 ){
                    dp[j][i] += dp[j][i-1];
                }
                if(j != 0){
                    dp[j][i] += dp[j-1][i];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
