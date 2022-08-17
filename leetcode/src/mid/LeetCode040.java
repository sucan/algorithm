package mid;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2021/9/6 21:45
 * @Description:
 */
public class LeetCode040 {
    static boolean[] vis = new boolean[100];

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return findAns(candidates,target,new LinkedList<>(),0);
    }

    public static List<List<Integer>> findAns(int[] candidates, int target, LinkedList<Integer> ans,int index){
        if(target < 0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0){
            List<Integer> tmp = new ArrayList<>(ans);
            result.add(tmp);
            return result;
        }
        for(int i = index;i<candidates.length;i++){

            if(!vis[i] ){
                if(i > 0 && candidates[i-1] == candidates[i] && !vis[i-1]){
                    continue;
                }
                vis[i] = true;
                ans.addLast(candidates[i]);
                List<List<Integer>> tmpResult = findAns(candidates,target-candidates[i],ans,i+1);
                if(tmpResult != null && tmpResult.size() > 0){
                    result.addAll(tmpResult);
                }
                ans.removeLast();
                vis[i] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,4,5,7};
        System.out.println(combinationSum2(array,6));
    }
}
