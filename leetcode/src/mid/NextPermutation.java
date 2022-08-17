package mid;

/**
 * Created by enpingkuang on 2020/8/8 1:21 PM
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int right = nums.length -1;
        int left = 0;
        for(int i = right;i>0;i--){
            if(nums[i] > nums[i-1]){
                left = i;
                int index = i;
                while(index <= right && nums[index] > nums[i-1] )index++;
                index--;
                int tmp = nums[i-1];
                nums[i-1] = nums[index];
                nums[index] = tmp;
                break;
            }
        }
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }

    }
}
