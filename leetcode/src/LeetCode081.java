/**
 * 核心思路是找到一段递增区间
 * 判断 [l,mid] 和 [mid + 1,r] 这两段区间中的区间哪一个是递增的
 * 然后再判断target是否在当前递增区间中
 * 如果在的话就在此区间中二分，不在的话就缩短此区间
 * 需要特判 l = mid = r 的情况
 * @Auther: kep
 * @Date: 2022/4/28 21:59
 * @Description:
 */
public class LeetCode081 {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return true;
            if(nums[mid] == nums[l] && nums[l] == nums[r]){
                l++;r--;
            }else if(nums[l] < nums[mid]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else if(nums[l] > nums[mid]){
                if(target > nums[mid] && target <=nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
