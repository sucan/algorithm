package mid;

/**
 * @Auther: kep
 * @Date: 2021/9/9 23:31
 * @Description:
 */
public class LeetCode055 {

    public boolean canJump(int[] nums) {
        int maxLength = nums[0] + 0;
        for(int i = 0;i<nums.length-1;i++){
            if(i > maxLength){
                return false;
            }
            if(i + nums[i] >maxLength){
                maxLength = i + nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
