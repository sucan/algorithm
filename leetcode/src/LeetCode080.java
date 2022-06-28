/**
 * @Auther: kep
 * @Date: 2022/4/28 21:59
 * @Description:
 */
public class LeetCode080 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int result = 0;
        int index = 0;
        while(index < nums.length){
            if(result == 0 || nums[result-1] != nums[index]){
                nums[result] = nums[index];
                result++;
                index++;
            }else {
                nums[result] = nums[index];
                result++;
                index++;
                while (index < nums.length && nums[index] == nums[result - 1]) index++;
            }
        }
        return result;
    }
}
