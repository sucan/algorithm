package DP;

import java.util.Scanner;

/**
 * 划分数问题
 *
 * 问题描述：
 *
 * 有n个数，需要将这n个数划分为不超过m份，问一共有多少种划分的情况
 *
 * Created by enpingkuang on 2020/8/2 1:08 AM
 */
public class PartitionNumbers {

    private static final int MOD = 1000005;
    private static int[][] dp = new int[105][100005];

    /**
     * n个数划分为不超过m份的划分总数叫做 n的m划分
     *
     * 用dp[i][j]来表示j的i划分，下面来推导一下状态转移方程
     *
     * j的i划分的可以用如下的方式来进行表示：
     *
     * a[1],a[2],......,a[i]
     *
     * 按照是否存在a[x] = 0,可以将上面的划分集合分为两类
     *
     * 不存在a[x] = 0:
     *  当不存在a[x] = 0的情况下，我们将每一个a都减一，得到的划分集合也是一个有效的划分，并且总数为dp[i][j-i]
     * 存在a[x] = 0:
     *  在存在a[x] =0的情况下，我们把等于0的那一位去掉，得到的划分集合也是一个有效的划分，并且总数为dp[i-1][j]
     *
     *  故最终的转移方程为dp[i][j] = dp[i-1][j] + dp[i][j-i]
     *
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        dp[0][0] = 1;
        for(int i = 1;i<=m;i++){
            for(int j = 0;j<=n;j++){
                if(j - i < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-i])%MOD;
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
