package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/29 00:38
 * @Description:
 */
public class LeetCode044 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 0;i<=s.length();i++){
            for(int j = 0;j<=p.length();j++){
                if(i > 0 && j>0) {
                    //*匹配一个字符
                    dp[i][j] |= (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?' || p.charAt(j - 1) == '*'));
                }
                if(i > 0 && j > 0) {
                    //*匹配多个字符
                    dp[i][j] |= (dp[i - 1][j] && p.charAt(j - 1) == '*');
                }
                if(j>0) {
                    //*匹配0个字符
                    dp[i][j] |= (dp[i][j - 1] && p.charAt(j - 1) == '*');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
