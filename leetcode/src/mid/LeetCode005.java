package mid;

public class LeetCode005 {
    /**
     * dp[i][j] 从第i个字符开始，到后面长度为j的字符串是否为回文
     *  dp[i][0] = true;
     *  dp[i][j] = dp[i+1][j-2] && s[i] == s[j];
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result = "";
        int maxCount = -1;
        for(int j = 0;j<s.length();j++){
            for(int i = 0;i<s.length();i++){
                if (i + j >= s.length()){
                    break;
                }
                if(j < 2){
                    dp[i][j] = s.charAt(i) == s.charAt(i + j);
                }else {
                    dp[i][j] = dp[i + 1][j - 2] && s.charAt(i) == s.charAt(i + j);
                }
                if (dp[i][j] && maxCount < j){
                    maxCount = j;
                    result = s.substring(i,i+j+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
}
