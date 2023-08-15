package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/3 23:47
 * @Description:
 */
public class LeetCode918 {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int ans = nums[0];
        for(int i = 0;i<nums.length;i++){
            dp[i] = nums[i];
            prefix[i] = nums[i];
            if(i > 0) {
                dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
                prefix[i] += prefix[i-1];
            }
            ans = Math.max(ans,dp[i]);
        }
        dp[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-1;i>=0;i--){
            suffix[i] = nums[i];
            if(i < nums.length-1){
                suffix[i] += suffix[i+1];
                dp[i] = Math.max(suffix[i],dp[i-1]);
            }
        }
        for(int i = 0;i<nums.length - 2;i++){
            ans = Math.max(ans, prefix[i] + dp[i+2]);
        }
        return ans;

    }
}
