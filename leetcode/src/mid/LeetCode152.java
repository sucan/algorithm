package mid;

/**
 * @Auther: kep
 * @Date: 2023/5/17 22:58
 * @Description:
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        Integer tmp = null;
        Integer ans = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(tmp == null || tmp == 0){
                tmp = nums[i];
            }else{
                tmp *= nums[i];
            }
            ans = Math.max(ans,tmp);
        }
        tmp = null;
        for(int i = nums.length-1;i>=0;i--){
            if(tmp == null || tmp == 0){
                tmp = nums[i];
            }else{
                tmp *= nums[i];
            }
            ans = Math.max(ans,tmp);
        }
        return ans;
    }
}
