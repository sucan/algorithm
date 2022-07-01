/**
 * @Auther: kep
 * @Date: 2022/7/1 22:25
 * @Description:
 */
public class LeetCode091 {

    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        //dp[i] 用前i个数可以形成的组合
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(getInt(s.charAt(0)) != 0) {
            dp[1] = 1;
        }
        for(int i = 2;i<=s.length();i++){
            int now = getInt(s.charAt(i-1));
            //单独成列
            if(now != 0){
                dp[i] += dp[i-1];
            }
            //和前一位组合
            int pre = getInt(s.charAt(i - 2));
            if(pre * 10 + now >= 10 && pre * 10 + now <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    private int getInt(Character c){
        return c - '0';
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode091().numDecodings("2611055971756562"));
    }
}
