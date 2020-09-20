package abc179;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * dp[i] 表示走到i点的方案数
 *
 * 因为只能在区间当中取数，同时对于每一个区间[a,b] , dp[b] = dp[i-b] + dp[i-b+1] + ...... + dp[i-a] （因为能取的数只有a~b）
 *
 * 因此转移方程为：
 *
 * i == 0 时 dp[i] = 1
 *
 * a[0] > i > 0
 *
 * dp[i] = 0;
 *
 * b[j] >= i >= a[j] 时：
 *
 * dp[i] = dp[i-a[j]] + ...... + dp[max(0,i-b[j])]
 *
 * 其他情况
 *
 * dp[i] = dp[i-1]
 *
 * Created by enpingkuang on 2020/9/19 7:53 下午
 */
public class D {
    private static int MOD = 998244353;
    private static long[] dp = new long[200005];
    private static long[] sum = new long[200005];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] l = new int[200005];
        int[] r = new int[200005];
        for(int i = 0;i<k;i++){
             l[i] = scanner.nextInt();
             r[i] = scanner.nextInt();
        }
        dp[0] = 1;
        sum[0] = 1;
        for(int i=1;i<n;i++) {
            for(int j = 0;j<k;j++){
                if(i >= l[j]){
                    long flag = i-r[j]-1 < 0?0:sum[i-r[j]-1];
                    dp[i] = ((dp[i] + sum[i-l[j]] - flag)%MOD + MOD)%MOD;
                }
            }
            sum[i] = (sum[i-1] + dp[i])%MOD;
        }
        System.out.println(dp[n-1]);
    }
}
