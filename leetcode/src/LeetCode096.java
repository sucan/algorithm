/**
 * 记忆化搜索
 * @Auther: kep
 * @Date: 2022/7/2 20:07
 * @Description:
 */
public class LeetCode096 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        return solve(n,dp);
    }

    private int solve(int n,int[] dp){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans += solve(i,dp) * solve(n-i-1,dp);
        }
        dp[n] = ans;
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode096().numTrees(19));
    }
}
