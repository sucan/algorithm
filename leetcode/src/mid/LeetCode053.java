package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/29 01:42
 * @Description:
 */
public class LeetCode053 {
    public int maxSubArray(int[] nums) {
        Integer sum = null;
        Integer ans = null;
        for(int i = 0;i<nums.length;i++){
            if(sum == null || sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            ans = ans == null?sum:Math.max(ans,sum);
        }
        return ans;
    }
}
