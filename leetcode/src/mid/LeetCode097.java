package mid;

/**
 * @Auther: kep
 * @Date: 2022/7/2 20:34
 * @Description:
 */
public class LeetCode097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j] 用前i个s1中字符 + 前j个s2中字符是否能够组合出 前 i+j 个s3
        boolean[][] dp = new boolean[s1.length()+1][s2.length() +1];
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        if(s1.length() == 0){
            return s2.equals(s3);
        }
        if(s2.length() == 0){
            return s1.equals(s3);
        }
        dp[0][0] = true;
        boolean ans = false;
        for(int i = 1;i<= s3.length();i++){
            for(int index_1 = 0;index_1<=Math.min(s1.length(),i);index_1++){
                int index_2 = i - index_1;
                if(index_2 > s2.length()){
                    continue;
                }
                //用s2补齐
                if(index_2 > 0) {
                    dp[index_1][index_2] |= dp[index_1][index_2 - 1] && s2.charAt(index_2 - 1) == s3.charAt(i-1);
                }
                //用s1补齐
                if(index_1 > 0){
                    dp[index_1][index_2] |= dp[index_1 - 1][index_2] && s1.charAt(index_1 - 1) == s3.charAt(i-1);
                }
                if(i == s3.length()){
                    ans |=  dp[index_1][index_2];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode097().isInterleave("aa","ab","abaa"));
    }
}
