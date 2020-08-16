package DP;

import java.util.Scanner;

/**
 * 多重集组合数问题
 * 问题描述：
 *
 * 有n种物品，第i个物品有a[i]个，从这些物品当中取m个，问一共有多少种取法
 *
 * Created by enpingkuang on 2020/8/15 3:34 PM
 */
public class CombinationNumberOfMultipleSets {
    private static int[] a = new int[100005];
    private static final int MOD = 1000000009;
    private static int[][] dp = new int[1000][1000];

    /**
     * 我们定义dp[i][j]:前i种数共取j个数的取法个数
     * 很容易就能得出的一个递推式
     * dp[i][j] = sigma(dp[i-1][j-k]) ( min(j,a[i]) >= k >=0)
     *
     * 因为有个k所以复杂度会是nm*m,不过直觉告诉我们这个转移方程有很多重复计算的地方，我们尝试优化一下
     *
     * dp[i][j-1] = sigma(dp[i-1][j-k-1]) ( min(j-1,a[i] )>= k >=0)
     *
     * 上面的式子分情况讨论可以展开为：
     *
     *  场景一：j -1 < a[i ] ==> j < a[i] +1 ==> j <= a[i]
     *
     *  dp[i][j] = sigma(dp[i-1][j-k]) ( j >= k >=0)
     *
     *           = dp[i-1][0]+dp[i-1][1]+.....+dp[i-1][j-1]+dp[i-1][j]
     *
     *  dp[i][j-1] = sigma(dp[i-1][j-k-1]) ( j-1 >= k >=0)
     *             = dp[i-1][0]+dp[i-1][1]+.....+dp[i-1][j-1]
     *
     *  dp[i][j] - dp[i][j-1] = dp[i-1][j]
     *
     *  场景二：j - 1 >= a[i] ==> j >= a[i] +1 ==> j > a[i]
     *
     *  dp[i][j] = sigma(dp[i-1][j-k]) ( a[i] >= k >=0)
     *           = dp[i-1][j-a[i]]+dp[i-1][j-a[i]+1]+......+dp[i-1][j-1]+dp[i-1][j]
     *
     *  dp[i][j-1] = sigma(dp[i-1][j-k-1]) ( a[i] >= k >=0)
     *             = dp[i-1][j-a[i]-1]+dp[i-1][j-a[i]]+......+dp[i-1][j-1]
     *
     *  dp[i][j] - dp[i]dp[j-1] = dp[i-1][j]-dp[i-1][j-a[i]-1]
     *
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 1;i<=n;i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(j > a[i]){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-a[i]-1];
                }else{
                    dp[i][j]  = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);

    }

}
