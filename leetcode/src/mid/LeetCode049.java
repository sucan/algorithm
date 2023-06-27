package mid;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:24
 * @Description:
 */
public class LeetCode049 {
    Map<String, List<String>> resultMap = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        resultMap.clear();
        for(String str:strs){
            String key = getKey(str);
            List<String> result = resultMap.computeIfAbsent(key,k ->  new ArrayList<String>() );
            result.add(str);
        }
        return new ArrayList<>(resultMap.values());
    }

    public String getKey(String str){
        char[] values = new char[str.length()];
        str.getChars(0,str.length(),values,0);
        Arrays.sort(values);
        return new String(values);
    }
}
