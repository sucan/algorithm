/**
 * @Auther: kep
 * @Date: 2022/4/26 23:24
 * @Description:
 */
public class LeetCode075 {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    void quickSort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int tmp = nums[start];
        int l = start;
        int r = end;
        while(l < r){
            while(l < r && nums[r] >= tmp)r--;
            nums[l] = nums[r];
            if(l == r){
                break;
            }
            l++;
            while(l <r && nums[l] <= tmp)l++;
            nums[r] = nums[l];
            if(l == r){
                break;
            }
            r--;
        }
        nums[l] = tmp;
        quickSort(nums,start,l-1);
        quickSort(nums,l+1,end);
    }
}
