package mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:06
 * @Description:
 */
public class LeetCode003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Boolean> exist = new HashMap<Character,Boolean>();
        int ans = 0;
        int leftIndex = 0,rightIndex = 0;
        for(;rightIndex < s.length();){
            while(exist.get(s.charAt(rightIndex)) != null){
                exist.remove(s.charAt(leftIndex++));
            }
            exist.put(s.charAt(rightIndex++),true);
            ans = ans > (rightIndex - leftIndex)?ans:(rightIndex - leftIndex);
        }
        return ans;
    }
}
