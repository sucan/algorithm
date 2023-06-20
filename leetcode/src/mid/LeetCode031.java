package mid;

import java.util.Arrays;

/**
 * 从后向前找到第一个升序数字对，较小值一定就是下一个排列需要变大的值
 * 变大的值需要最小，那么就是从后向前遍历，第一个比较小值大的值
 * 替换完较小值之后，对后续数列进行排序
 * @Auther: kep
 * @Date: 2023/6/19 23:30
 * @Description:
 */
public class LeetCode031 {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            for(int i = 0;i<nums.length/2;i++){
                int tmp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = tmp;
            }
            return;
        }
        for(int i = nums.length - 1;i>index;i--){
            if(nums[i] > nums[index]){
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                break;
            }
        }
        Arrays.sort(nums,index+1,nums.length);
    }
}
