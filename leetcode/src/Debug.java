/**
 * @Auther: kep
 * @Date: 2023/8/13 18:28
 * @Description:
 */
public class Debug {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][prices.length+1];
        dp[0][1] = Integer.MIN_VALUE + 20001;
        for(int i = 1;i<=prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i-1],dp[i-1][1]);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        new Debug().maxProfit(new int[]{7,1,5,3,6,4});
    }

}
