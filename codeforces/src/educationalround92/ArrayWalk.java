package educationalround92;

import java.util.Scanner;

/**
 * codeforces link:https://codeforces.com/contest/1389/problem/B
 * Created by enpingkuang on 2020/8/1 3:26 PM
 */
public class ArrayWalk {


    /**
     *  这道题最开始读题读错了，误以为一个点只能回退一次，因此在错误的道路上越走越远了，一直在用贪心的方法去做，其实像这类有明确状态转移的问题，正解当然是DP
     *  从题干上给的数据规模来看，比较容易想到的一个表达式为：dp[i][j] 表示停下来的终点为i，在此之前已经回退了j次，取到的最大值
     *  然后下面就来推状态转移方程：
     *  首先到达i有两种方式，一种是从i-1 直接走过来，一种是从i+1回退回来，就这两种情况分别讨论
     *
     *  从i-1到i：
     *      当i = 0 时此状态不存在
     *      当i不等于0时,有两种状态:
     *          1. 从(i-1) -> (i) 没有发生回退操作：dp[i][j] = dp[i-1][j] + a[i]
     *          2. 从(i-1) -> (i) 发生了一次回退操作：dp[i][j] = max(dp[i][j],dp[i-1][j-1] + a[i] + a[i-1] + a[i])
     *  从i+1到i:
     *      当i >= k 时，此状态不存在，因为最多只能走到k了，不可能到达k+1
     *      当i < k 时，只有一种状态：
     *          1. 从(i+1) -> (i) 一定会有一次回退操作:dp[i][j] = dp[i+1][j-1] + a[i],但是通过这个转移方法根本没有办法进行计算，因此我们需要对dp[i+1][j-1]进行一下变形
     *          首先题目上有一个前提条件就是不能连续回退两次，也就是说只要能够从（i+1）回退到（i）那么就说明了之前到达(i+1)这个点的方式一定是从(i)到（i+1）的，不可能是从（i+2）回退至i + 1
     *          因此这里面的dp[i+1][j-1] 其实就等同于 dp[i][j-1] + a[i+1],因此最终的转移方程可以写作：
     *          dp[i][j] = dp[i][j-1] + a[i+1] + a[i]
     *
     *  由此，状态转移方程就全部推导出来了，同时我们能够算出要达到dp[i][j]这个状态需要移动 i + 2*j 次因此我们只需要计算出 i + 2*j <= k的所有情况，然后再取最大值，这样我们就能得到答案了
     *
     *
     */

    private static int[] a = new int[300001];
    private static int[][] dp = new int[300001][6];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int z = scanner.nextInt();
            long sum = 0;
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
                if(i<=k){
                    sum+=a[i];
                }
            }
            init(n,z);
            dp[0][0] = a[0];
            for(int i = 0;i<=k;i++){
                for(int j = 0;j<=z;j++){
                    if(i + 2*j > k){
                        continue;
                    }
                    if(i > 0){
                        dp[i][j] =  dp[i - 1][j] + a[i];
                        if(j > 0) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+a[i]+a[i-1] +a[i]);
                        }
                    }
                    if(i < k && j>0){
                        dp[i][j] =   Math.max(dp[i][j],dp[i][j-1] + a[i]+a[i+1]);
                    }
                    sum = Math.max(sum,dp[i][j]);
                }
            }
            System.out.println(sum);
        }
    }

    private static void init(int n,int z){
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=z;j++){
                dp[i][j] = -1;
            }
        }
    }



}
