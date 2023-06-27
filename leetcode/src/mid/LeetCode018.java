package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/27 23:53
 * @Description:
 */
public class LeetCode018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return findNSum(4,nums,0,target);
    }

    public List<List<Integer>> findNSum(int n,int[] nums,int start,long target){
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 2){
            return ans;
        }
        if(n == 2){
            int left = start,right = nums.length-1;
            while(left < right){
                int tmpL = nums[left];
                int tmpR = nums[right];
                if(tmpL + tmpR == target){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(tmpL);
                    subList.add(tmpR);
                    ans.add(subList);
                    while(left < right && nums[left] == tmpL){left++;}
                    while(left < right && nums[right] == tmpR){right--;}
                }else if(tmpL + tmpR < target){
                    while(left < right && nums[left] == tmpL){left++;}
                }else{
                    while(left < right && nums[right] == tmpR){right--;}
                }
            }
        }else{
            for(int i = start;i<nums.length;){
                List<List<Integer>> tmpList = findNSum(n-1,nums,i+1,target-nums[i]);
                if(!tmpList.isEmpty()){
                    for(List<Integer> subList:tmpList){
                        subList.add(nums[i]);
                        ans.add(subList);
                    }
                }
                int tmpNum = nums[i];
                while(i<nums.length && tmpNum == nums[i]){i++;}
            }
        }
        return ans;
    }
}
