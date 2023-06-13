package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/13 21:50
 * @Description:
 */
public class LeetCode022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans,new char[2*n],0,0,0,n);
        return ans;
    }

    private void dfs(List<String> ans,char[] tmp,int index,int leftNum,int rightNum,int n){
        if(leftNum == rightNum && rightNum == n){
            ans.add(new String(tmp));
            return;
        }
        if(leftNum < n){
            tmp[index] = '(';
            dfs(ans,tmp,index+1,leftNum+1,rightNum,n);
        }
        if(rightNum < leftNum){
            tmp[index] = ')';
            dfs(ans,tmp,index+1,leftNum,rightNum+1,n);
        }
    }
}
