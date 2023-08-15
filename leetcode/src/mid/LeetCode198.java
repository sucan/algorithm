package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/12 19:16
 * @Description:
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i = 1;i<=nums.length;i++){
            dp[i] = Math.max(dp[i],dp[i-1]);
            dp[i] = Math.max(dp[i], i > 1?dp[i - 2] + nums[i - 1]:nums[i-1]);
        }
        return dp[nums.length];
    }
}
