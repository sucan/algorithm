package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 暴力做法需要3重循环，会TLE，需要考虑减枝
 * 对数组进行升序排序处理后在 O(n)时间内就可以求得求两数之和，因此只需要枚举最小值，然后不断求两数之和即可，复杂度为O(n*n)
 */
public class LeetCode015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return findNSum(3,nums,0,0);
    }

    public static List<List<Integer>> findNSum(int n,int[] nums,int start,int target){
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


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
