package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2021/9/1 23:07
 * @Description:
 */
public class LeetCode039 {

    public static List<List<Integer>> findPath(int[] candidates,int index,int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(index == 0){
            if(target % candidates[0] == 0){
                for(int i = 0;i<target/candidates[0];i++){
                    tmp.add(candidates[0]);
                }
                result.add(tmp);
                return result;
            }
            return null;
        }
        for(int i = 0;i*candidates[index] <= target;i++){
            List<List<Integer>> tmpResult = findPath(candidates, index - 1, target - i * candidates[index]);
            if(tmpResult != null) {
                for (List<Integer> sub : tmpResult) {
                    sub.addAll(tmp);
                }
                result.addAll(tmpResult);
            }
            tmp.add(candidates[index]);
        }
        return result;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = findPath(candidates,candidates.length-1,target);
        if(result == null){
            return new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2,3};

        List<List<Integer>> result = combinationSum(array,5);
        System.out.println(result);
    }
}
