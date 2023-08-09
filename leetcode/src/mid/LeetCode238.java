package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/5 19:51
 * @Description:
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            pre[i] = i == 0?nums[i]:pre[i-1]*nums[i];
        }
        for(int i = nums.length-1;i>=0;i--){
            suf[i] = i == nums.length-1?nums[i]:suf[i+1]*nums[i];
        }
        int[] ans = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(i == 0){
                ans[i] = suf[i+1];
            }else if(i == nums.length -1){
                ans[i] = pre[i-1];
            }else{
                ans[i] = pre[i-1] * suf[i+1];
            }
        }
        return ans;
    }
}
