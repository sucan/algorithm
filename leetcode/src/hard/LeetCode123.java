package hard;

/**
 * @Auther: kep
 * @Date: 2023/7/5 00:13
 * @Description:
 */
public class LeetCode123 {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length+1][3][2];
        for(int i = 0;i<=2;i++){
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for(int i = 0;i<=prices.length;i++){
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for(int i = 1;i<=prices.length;i++){
            for(int k = 1;k<=2;k++){
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i-1]);
            }
        }
        return dp[prices.length][2][0];
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        new LeetCode123().maxProfit(prices);
    }
}
