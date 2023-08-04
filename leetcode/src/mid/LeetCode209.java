package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/3 22:31
 * @Description:
 */
public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        if(nums.length == 0){
            return ans;
        }
        int left = 0,right = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while(left <= right && sum >= target){
                ans = Math.min(ans, right - left +1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans ==Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        new LeetCode209().minSubArrayLen(7,nums);
    }
}
