package hard;

/**
 * @Auther: kep
 * @Date: 2023/8/11 20:52
 * @Description:
 */
public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][k+1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = dp[0][j][1] = -2000001;
        }
        dp[0][0][0] = 0;
        int ans = 0;
        for(int i= 1;i<=prices.length;i++){
            for(int j = 0;j<=k;j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
                dp[i][j][1] = dp[i-1][j][1];
                if(j > 0){
                    dp[i][j][1] = Math.max(dp[i][j][1],dp[i-1][j-1][0] - prices[i-1]);
                }
                ans = Math.max(ans,dp[i][j][0]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {2,4,1};
        new LeetCode188().maxProfit(2,x);
    }
}
