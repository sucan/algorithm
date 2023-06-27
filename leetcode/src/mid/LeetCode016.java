package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/27 23:50
 * @Description:
 */
public class LeetCode016 {
    public int threeSumClosest(int[] nums, int target) {
        Integer ans = null;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;){
            int tmp = nums[i];
            Integer tmpAns = getSolution(nums,i+1,target-nums[i]);
            if(tmpAns != null){
                if(ans == null || Math.abs(tmpAns) < Math.abs(ans)){
                    ans = tmpAns;
                }
                while(i < nums.length && nums[i] == tmp){i++;}
            }else{
                i++;
            }
        }
        return target - ans;
    }

    public Integer getSolution(int[] nums,int start,int value){
        int left = start,right = nums.length-1;
        Integer ans = null;
        while(left < right){
            int tmpR = nums[right];
            int tmpL = nums[left];
            if(nums[left] + nums[right] > value){
                if(ans == null || Math.abs(ans) > nums[left] + nums[right] - value){
                    ans = value - nums[left] - nums[right];
                }
                while(right > left && nums[right] == tmpR){right--;}
            }else if(nums[left] + nums[right] < value){
                if(ans == null || Math.abs(ans) > value - nums[left] - nums[right]){
                    ans = value - nums[left] - nums[right];
                }
                while(right > left && nums[left] == tmpL){left++;}
            }else{
                List<Integer> subList = new ArrayList<>();
                return 0;
            }
        }
        return ans;
    }
}
