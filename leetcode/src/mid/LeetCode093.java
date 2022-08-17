package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/7/2 12:59
 * @Description:
 */
public class LeetCode093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(1,0,s,result,new ArrayList<>());
        return result;
    }

    private void dfs(int part,int index,String s,List<String> result,List<String> tmp){
        if(index == s.length() && part == 5){
            result.add(String.join(".",tmp));
            return;
        }
        if(index == s.length() || part == 5){
            return;
        }
        for(int i = index;i<Math.min(s.length(),index+3);i++){
            String subString = s.substring(index,i+1);
            if(isValidNumber(subString)){
                tmp.add(subString);
                dfs(part+1,i+1,s,result,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    private boolean isValidNumber(String x){
        if(x.charAt(0) == '0'){
            if(x.length() == 1){
                return true;
            }
            return false;
        }
        for(int i = 0;i<x.length();i++){
            if(x.charAt(i) < '0' || x.charAt(i) > '9'){
                return false;
            }
        }
        return Integer.parseInt(x) <= 255;
    }

    public static void main(String[] args) {
        new LeetCode093().restoreIpAddresses("25525511135");
    }
}
