package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * s 拆分为由多个word组成的数组
 * 滑动窗口判断是否有解
 * @Auther: kep
 * @Date: 2023/6/18 17:33
 * @Description:
 */
public class LeetCode030 {
    public List<Integer> findSubstring(String s, String[] words) {
        int ls = s.length();
        int lm = words[0].length();
        int m = words.length;
        List<Integer> ans = new ArrayList<>();
        Map<String,Integer> wordsMap = new HashMap<>();
        for(String word:words){
            Integer value = wordsMap.get(word);
            wordsMap.put(word,value == null?1:value+1);
        }
        for(int i = 0;i<lm;i++){
            String[] subArray = new String[(ls - i) / lm];
            int start = i;
            int index = 0;
            Map<String, Integer> subArrayMap = new HashMap<>();
            while (start + lm <= ls) {
                subArray[index] = s.substring(start, start + lm);
                if(index < m) {
                    Integer wordCount = subArrayMap.get(subArray[index]);
                    subArrayMap.put(subArray[index], wordCount == null ? 1 : wordCount + 1);
                }
                start += lm;
                index++;
            }
            for(int j = 0;j + m<=subArray.length;j++){
                if(j > 0){
                    Integer value = subArrayMap.get(subArray[j-1]);
                    if(value == 1){
                        subArrayMap.remove(subArray[j-1]);
                    }else {
                        subArrayMap.put(subArray[j - 1], value - 1);
                    }
                    value = subArrayMap.get(subArray[j+m-1]);
                    subArrayMap.put(subArray[j+m-1],value == null?1:value+1);
                }
                if(checkMapEquals(wordsMap,subArrayMap)){
                    ans.add(j*lm+i);
                }
            }
        }
        return  ans;
    }

    private boolean checkMapEquals(Map<String,Integer> a,Map<String,Integer> b){
        if(a == null || b == null){
            return false;
        }
        if(a.size() != b.size()){
            return false;
        }
        for(Map.Entry<String,Integer> entry:a.entrySet()){
            if(!entry.getValue().equals(b.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"word","good","best","good"};
        new LeetCode030().findSubstring("wordgoodgoodgoodbestword",words);
    }
}
