package abc178;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/13 9:29 下午
 */
public class D {
    private static long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[2001][2001];
        long ans = 0;
        //dp[i][j]   j的i划分
        dp[0][0] = 1;
        for(int i = 1;i<=n/3;i++){
            for(int j = 1;j<=n;j++){
                if(j - 3 >= 0){
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-3])%MOD;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
            ans = (ans + dp[i][n])%MOD;
        }
        System.out.println(ans);
    }
}
