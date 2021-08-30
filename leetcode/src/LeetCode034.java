/**
 * @Auther: kep
 * @Date: 2021/8/30 22:56
 * @Description:
 */
public class LeetCode034 {
    public int[] searchRange(int[] nums, int target) {
        int l = findLeft(nums,target);
        int r = findRight(nums,target);
        return new int[]{l,r};
    }


    public  int findLeft(int[] nums, int target){
        int l = 0,r = nums.length -1;
        while(l<=r){
            int mid = (l+r)>>1;
            if(nums[mid] == target){
                r = mid - 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }
        }
        if(l == nums.length || nums[l] != target){
            return -1;
        }
        return l;
    }

    public int findRight(int[] nums, int target){
        int l = 0,r = nums.length -1;
        while(l<=r) {
            int mid = (l + r) >> 1;
            if(nums[mid] == target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r= mid -1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }
        }
        if(r < 0 || nums[r] != target){
            return -1;
        }
        return r;
    }

    public static void main(String[] args) {

    }
}
