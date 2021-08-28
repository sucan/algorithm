/**
 * 一共有两个解法，第一个解法比较容易想到，就是先二分找到极值，划分为两个递增序列，然后分别去执行二分查找
 * 第二个解法不太容易想到，主要思想是利用数列的单调特性在原数组中进行二分
 * @Auther: kep
 * @Date: 2021/8/28 16:31
 * @Description:
 */
public class LeetCode033 {

    public int search_classic(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while(l <= r){
            int mid = (l+r)>>1;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] < nums[r]){
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(target < nums[mid] && target >= nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return -1;

    }

    public int search_normal(int[] nums, int target) {
        int ll = 0,rr = nums.length -1;
        int lr = findMid(nums);
        int rl = lr + 1;
        int lResult = binarySearch(nums,target,ll,lr);
        if(lResult != -1){
            return lResult;
        }
        if(target > nums[ll]){
            return -1;
        }
        return binarySearch(nums,target,rl,rr);

    }

    public static int findMid(int[] nums){
        int leftTarget = nums[0];
        int l = 0,r = nums.length-1;
        while(l <= r){
            int mid = (l+r)>>1;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid ==nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }else if(nums[mid] >= leftTarget){
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] nums,int target,int l,int r){
        while(l <= r){
            int mid = (l+r)>>1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid -1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
