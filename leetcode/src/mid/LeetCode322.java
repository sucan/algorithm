package mid;

import java.util.Arrays;

/**
 * @Auther: kep
 * @Date: 2023/8/12 18:26
 * @Description:
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][10001];
        for(int i = 0;i<coins.length+1;i++){
            for(int w = 0;w<=10000;w++) {
                dp[i][w] = Integer.MAX_VALUE - 1;
            }
        }
        for(int i = 0;i<coins.length;i++){
            if(coins[i] > 10000){
                continue;
            }
            dp[i+1][coins[i]] = 1;
            dp[i+1][0] = 0;
        }
        for(int i = 1;i<=coins.length;i++){
            for(int w = 0;w<=10000;w++) {
                dp[i][w] = Math.min(dp[i-1][w],dp[i][w]);
                if(w>=coins[i-1]){
                    dp[i][w] = Math.min(dp[i][w-coins[i-1]] +1,dp[i][w]);
                    dp[i][w] = Math.min(dp[i][w],dp[i-1][w-coins[i-1]] +1);
                }
            }
        }
        if(dp[coins.length][amount] == Integer.MAX_VALUE - 1 ){
            return -1;
        }
        return dp[coins.length][amount];
    }

    public int coinChange2(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]= 0;
        for(int i = 1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE - 1){
            return -1;
        }
        return dp[amount];
    }
}
