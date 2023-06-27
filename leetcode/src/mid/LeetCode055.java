package mid;

/**
 * @Auther: kep
 * @Date: 2021/9/9 23:31
 * @Description:
 */
public class LeetCode055 {

    public boolean canJump(int[] nums) {
        int start = 0;
        int maxLength = nums[start] + start;
        while (maxLength < nums.length-1){
            int tmpIndex = start;
            for(int i = start;i<=start+nums[start];i++){
                if(nums[i] + i > maxLength){
                    maxLength = nums[i] + i;
                    tmpIndex = i;
                }
            }
            if(tmpIndex == start){
                return false;
            }
            start = tmpIndex;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
