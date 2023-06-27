package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/28 00:38
 * @Description:
 */
public class LeetCode041 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            while(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]){
                int tmp = nums[i];
                int index = nums[i]-1;
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
