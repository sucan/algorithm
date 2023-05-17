package hard;

import java.util.Arrays;

/**
 * @Auther: kep
 * @Date: 2023/5/17 23:33
 * @Description:
 */
public class LeetCode154 {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int l = 0,r = nums.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else if(nums[mid] == nums[r]){
                r = mid -1;
            }else{
                r = mid;
            }
        }
        return nums[l];
    }
}
