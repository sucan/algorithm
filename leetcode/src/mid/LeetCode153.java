package mid;

/**
 * @Auther: kep
 * @Date: 2023/5/17 23:13
 * @Description:
 */
public class LeetCode153 {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int l = 0,r = nums.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else if(nums[mid] == nums[r]){
                return nums[mid];
            }else{
                r = mid;
            }
        }
        return nums[l];
    }
}
