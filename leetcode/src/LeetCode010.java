public class LeetCode010 {
    /**
     * dp[i][j] 表示 s[0~i] 与 p[0~j] 是否匹配
     * 枚举p[j] 为'*'的所有情况，一共三种
     *  1. 匹配0个
     *  2. 匹配1个
     *  3. 匹配多个
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1;j<=p.length();j++){
            if (p.charAt(j-1) == '*'){
                if(j >=2){
                    //匹配0个
                    dp[0][j] |= dp[0][j-2];
                }
                //匹配一个
                dp[0][j] |= dp[0][j-1];
            }
        }
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=p.length();j++){
                if(p.charAt(j-1) == '*'){
                    if(j >= 2) {
                        //0个匹配
                        dp[i][j] |= dp[i][j -2];
                        //多个匹配
                        dp[i][j] |= dp[i-1][j] && equals(s.charAt(i-1),p.charAt(j-2));
                    }
                    //1个匹配
                    dp[i][j] |= dp[i][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] && equals(s.charAt(i-1), p.charAt(j-1));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private static boolean equals(char a,char b){
        if (a == '.' || b == '.'){
            return true;
        }
        return a == b;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab",".*"));
    }
}
