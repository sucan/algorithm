package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/12 18:11
 * @Description:
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        int ans = 1;
        for(int i = 0;i<nums.length;i++){
            int index = upper_bound(dp,nums.length,nums[i]);
            dp[index] = nums[i];
            ans = Math.max(ans,index+1);
        }
        return ans;
    }

    private int upper_bound(int[] dp,int n,int target){
        int left = 0;
        int right = n;
        while(left < right){
            int mid = (left + right)>>1;
            if(dp[mid] == target){
                return mid;
            }else if(dp[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        new LeetCode300().lengthOfLIS(nums);
    }
}
