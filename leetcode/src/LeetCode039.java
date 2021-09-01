import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2021/9/1 23:07
 * @Description:
 */
public class LeetCode039 {

    static boolean[][] dp = new boolean[31][501];

    public static List<List<Integer>> findPath(int[] candidates,int index,int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(index == 0){
            if(target % candidates[0] == 0){
                for(int i = 0;i<target/candidates[0];i++){
                    tmp.add(candidates[0]);
                }
            }
            result.add(tmp);
            return result;
        }
        for(int i = 0;i*candidates[index] <= target;i++){
            if(dp[index-1][target-i*candidates[index]]){
                List<List<Integer>> tmpResult = findPath(candidates,index-1,target-i*candidates[index]);
                for(List<Integer> sub:tmpResult){
                    sub.addAll(tmp);
                }
                result.addAll(tmpResult);
            }
            tmp.add(candidates[index]);
        }
        return result;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        for(int i = 0;i*candidates[0]<= 500 ;i++) {
            dp[0][candidates[0]*i] = true;
        }
        for(int i = 1;i<candidates.length;i++){
            for(int j = 0;j<=500;j++){
                dp[i][j] |= dp[i-1][j];
                if(j>=candidates[i]){
                    dp[i][j] |= dp[i][j-candidates[i]];
                }
            }
        }
        if(!dp[candidates.length-1][target]){
            return new ArrayList<>();
        }
        return findPath(candidates,candidates.length-1,target);
    }

    public static void main(String[] args) {
        int[] array = {2,3};

        List<List<Integer>> result = combinationSum(array,5);
        System.out.println(result);
    }
}
