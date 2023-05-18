package mid;

/**
 * @Auther: kep
 * @Date: 2023/5/18 22:58
 * @Description:
 */
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int left = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            int right = Integer.MIN_VALUE;
            if(i != nums.length -1){
                right = nums[i+1];
            }
            if(nums[i] >= left && nums[i] > right){
                return i;
            }
            left = nums[i];
        }
        return 0;
    }
}
