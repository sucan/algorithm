package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/4/27 22:23
 * @Description:
 */
public class LeetCode077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,new LinkedList<>(),1,n,k);
        return result;
    }

    void dfs(List<List<Integer>> result, LinkedList<Integer> tmp, int start, int end,int k){
        if(tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        if(start > end){
            return;
        }
        tmp.add(start);
        dfs(result,tmp,start+1,end,k);
        tmp.removeLast();
        dfs(result,tmp,start+1,end,k);
    }
}
