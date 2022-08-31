package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/9/1 00:19
 * @Description:
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s,0,ans,new ArrayList<>());
        return ans;
    }

    private void dfs(String s,int index,List<List<String>> ans,List<String> tmpList){
        if(index == s.length()){
            ans.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i = 0;i<s.length()-index;i++){
            if(isPalindrome(s,index,index+i)){
                tmpList.add(s.substring(index,index+i+1));
                dfs(s,index+i+1,ans,tmpList);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
