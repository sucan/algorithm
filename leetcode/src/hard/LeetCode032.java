package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/21 00:13
 * @Description:
 */
public class LeetCode032 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                if(i != 0 && s.charAt(i-1) == '('){
                    int tmp = i-2>=0?dp[i-2]:0;
                    dp[i] = tmp + 2;
                }else{
                    int tmpIndex = i-1;
                    if (tmpIndex >=0 && dp[tmpIndex] != 0 && (tmpIndex - dp[tmpIndex] >=0 && s.charAt(tmpIndex - dp[tmpIndex]) == '(')) {
                        dp[i] += dp[tmpIndex] +2;
                        if(tmpIndex - dp[tmpIndex] > 0){
                            dp[i] += dp[tmpIndex - dp[tmpIndex]-1];
                        }
                    }
                }
            }else{
                dp[i] = 0;
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode032().longestValidParentheses("()(())");
    }
}
