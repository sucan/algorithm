package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kep
 * @Date: 2023/6/30 23:25
 * @Description:
 */
public class LeetCode076 {
    public String minWindow(String s, String t) {
        int ans = Integer.MAX_VALUE;
        int indexL = -1,indexR = -1;
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        initMap(t,tMap);
        int l = 0,r = 0;
        while(r < s.length()){
            while (r < s.length() && !isValid(sMap,tMap)){
                putCharacter(s.charAt(r),sMap);
                r++;
            }
            while(l < r && isValid(sMap,tMap)){
                if(r-l < ans){
                    ans = r-l;
                    indexL = l;
                    indexR = r;
                }
                removeCharacter(s.charAt(l),sMap);
                l++;
            }
        }
        if(indexL == -1){
            return "";
        }
        return s.substring(indexL,indexR);
    }

    private boolean isValid(Map<Character,Integer> sMap,Map<Character,Integer> tMap){
        for(Map.Entry<Character,Integer> entry:tMap.entrySet()){
            Character c = entry.getKey();
            Integer count = entry.getValue();
            Integer tmp = sMap.get(c);
            if(tmp == null || tmp < count){
                return false;
            }
        }
        return true;
    }

    private void putCharacter(Character c,Map<Character,Integer> sMap){
        Integer count = sMap.get(c);
        if(count== null){
            count = 0;
        }
        sMap.put(c,++count);
    }

    private void removeCharacter(Character c,Map<Character,Integer> sMap){
        Integer count = sMap.get(c);
        if(count == null || --count == 0){
            sMap.remove(c);
        }else{
            sMap.put(c,count);
        }
    }

    private void initMap(String s,Map<Character,Integer> sMap){
        for(int i =0;i<s.length();i++){
            Character c = s.charAt(i);
            putCharacter(c,sMap);
        }
    }

    public static void main(String[] args) {
        new LeetCode076().minWindow("ADOBECODEBANC","ABC");
    }

}
