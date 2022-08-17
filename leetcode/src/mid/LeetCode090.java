package mid;

import java.util.*;

/**
 * 首先是dfs求全组合，对于一个数而言就两种状态，选或者不选，dfs求全组合就是遍历每个数的这两种情况
 * 画出搜索树进行剪枝
 * 剪枝策略是对于上一次没有选择num[index-1] 的场景，如果num[index] == num[index - 1] ，那么nums[index]也不应该选
 * 因为如果选择了的话必然和上一次选择了num[index-1] 时的结果重复
 * @Auther: kep
 * @Date: 2022/6/30 22:45
 * @Description:
 */
public class LeetCode090 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result,new LinkedList<>(),nums,0,false);
        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> subArray, int[] nums, int index,boolean flag){
        if(index == nums.length) {
            result.add(new ArrayList<>(subArray));
            return;
        }
        dfs(result, subArray, nums, index + 1, false);
        //剪枝
        if (index != 0 && !flag && nums[index] == nums[index - 1]) {
            return;
        }
        subArray.add(nums[index]);
        dfs(result, subArray, nums, index+ 1, true);
        subArray.removeLast();
    }

    public static void main(String[] args) {
        int[] x = {1,2,2};
        new LeetCode090().subsetsWithDup(x);
    }
}
