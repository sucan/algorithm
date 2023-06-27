package mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: kep
 * @Date: 2023/6/27 23:51
 * @Description:
 */
public class LeetCode017 {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }
        Map<String,List<Character>> number2ListMap = new HashMap<>();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        int index = 0;
        for(int i = 2;i<= 9;i++){
            int count = i == 7 ||  i== 9?4:3;
            List<Character> tmp = new ArrayList<Character>();
            while(count-- > 0){
                tmp.add(characters.charAt(index++));
            }
            number2ListMap.put(""+i,tmp);
        }
        List<String> ans = new ArrayList<>();
        solve(0,"",digits,number2ListMap,ans);
        return ans;
    }

    public void solve(int index,String tmp,String digits,Map<String,List<Character>> number2ListMap,List<String> ans){
        if(index == digits.length()){
            ans.add(tmp);
            return;
        }
        List<Character> list = number2ListMap.get(digits.charAt(index)+"");
        for(Character character:list){
            solve(index+1,tmp+""+character,digits,number2ListMap,ans);
        }
    }
}
