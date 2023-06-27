package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:32
 * @Description:
 */
public class LeetCode1513 {
    public int numSub(String s) {
        long mod = 1000000007;
        long[] dp = new long[100005];
        long ans = 0;
        for(int i = 0;i<s.length();i++){
            int tmp = 0;
            if(i != 0){
                tmp = s.charAt(i-1) - '0';
            }
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }else{
                if(i == 0){
                    dp[i] = 1;
                }else{
                    dp[i] = tmp * dp[i-1] + 1;
                }
            }
            ans = (ans + dp[i])%mod;
        }
        return (int)ans;
    }
}
