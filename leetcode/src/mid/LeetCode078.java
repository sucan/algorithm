package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/4/27 22:23
 * @Description:
 */
public class LeetCode078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<=nums.length;i++){
            List<List<Integer>> tmp = new ArrayList<>();
            dfs(tmp,new LinkedList<>(),nums,0,nums.length-1,i);
            result.addAll(tmp);
        }
        return result;
    }

    void dfs(List<List<Integer>> result, LinkedList<Integer> tmp,int[] nums, int start, int end,int k){
        if(tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        if(start > end){
            return;
        }
        tmp.add(nums[start]);
        dfs(result,tmp,nums,start+1,end,k);
        tmp.removeLast();
        dfs(result,tmp,nums,start+1,end,k);
    }
}
