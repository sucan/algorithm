package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:23
 * @Description:
 */
public class LeetCode047 {
    static boolean[] vis = new boolean[201];
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,nums,result,new LinkedList<>());
        return result;
    }

    public static void dfs(int deep, int[] nums, List<List<Integer>> result, LinkedList<Integer> ans){
        if(deep == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0;i< nums.length;i++){
            if(!vis[i]){
                if(i>0 && nums[i-1] == nums[i] && !vis[i-1]){
                    continue;
                }
                vis[i] = true;
                ans.addLast(nums[i]);
                dfs(deep+1,nums,result,ans);
                ans.removeLast();
                vis[i] = false;
            }
        }
    }
}
