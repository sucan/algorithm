package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/13 20:50
 * @Description:
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,0,nums.length-1,nums.length-k);
    }

    private int findKthLargest(int[] nums,int l,int r,int targetIndex){
        int index = quickSelect(nums,l,r);
        if(index == targetIndex){
            return nums[index];
        }else if(index > targetIndex){
            return index-1 < 0?nums[0]:findKthLargest(nums,l,index-1,targetIndex);
        }else {
            return index+1 >= nums.length? nums[nums.length-1]:findKthLargest(nums,index+1,r,targetIndex);
        }
    }

    private int quickSelect(int[] nums,int l,int r){
        int x = nums[l];
        int tmpIndex = l;
        int currentIndex = l;
        for(int i = l;i<=r;i++){
            if(nums[i] < x){
                swap(nums,currentIndex++,i);
                tmpIndex = i;
            }
        }
        if(x != nums[currentIndex]) {
            swap(nums, currentIndex, tmpIndex);
        }
        return currentIndex;
    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        new LeetCode215().findKthLargest(new int[]{5,2,4,1,3,6,0},4);
    }
}
