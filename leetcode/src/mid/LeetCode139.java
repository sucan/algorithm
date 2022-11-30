package mid;

import java.util.List;

/**
 * dp[i] 第i行之前是否已有匹配
 * @Auther: kep
 * @Date: 2022/11/30 23:15
 * @Description:
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[301];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j =0;j<wordDict.size();j++){
                if(dp[i]){
                    break;
                }
                int preIndex = i-wordDict.get(j).length();
                if(preIndex < 0){
                    continue;
                }
                dp[i] = dp[preIndex] && compare(wordDict.get(j),s,preIndex,wordDict.get(j).length());
            }
        }
        return dp[s.length()];
    }

    private boolean compare(String s1,String s2,int start,int length){
        for(int i = 0;i<length;i++){
            if(s1.charAt(i) != s2.charAt(start + i)){
                return false;
            }
        }
        return true;
    }
}
