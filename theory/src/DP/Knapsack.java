package DP;

import java.util.Scanner;

/**
 *
 * 背包问题
 * Created by enpingkuang on 2020/8/1 2:34 PM
 */
public class Knapsack {

    public static void main(String[] args){


    }

    /**
     * 0-1 背包问题
     *
     * 问题描述：
     *
     * 有n个重量为w[i]的物品，各自的价值为v[i],现在有一个容量为W的背包
     * 需要选择一些物品放入背包里面，使得物品重量总和小于等于W，并且价值总和最大
     * 问最大价值是多少
     *
     * 解法：
     *
     *  用dp[i][j] 来表示从前i个物品中，选取总重量为j的物品所能够得到的最大价值
     *  那么来推导一下状态转移方程：
     *
     *  对于状态dp[i][j] 来说一共有两种状态，分别为:
     *      1.取w[i]的物品(j >= w[i])，此时的状态状态方程为 dp[i][j] = dp[i-1][j-w[i]] + v[i];
     *      2.不取w[i]的物品(w[i] >=j >=0) dp[i][j] = dp[i-1][j]
     *
     *
     *
     */
    private void solution1(){
        int n,W;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        W = scanner.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for(int i = 0;i<n;i++){
            w[i] = scanner.nextInt();
        }
        for(int i = 0;i<n;i++){
            v[i] = scanner.nextInt();
        }
        int[][] dp = new int[n+1][W+1];
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=W;j++){
                if(j < w[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        //由于状态转移方程中只涉及到i和i-1这两个状态，因此该状态转移方程还可以优化一下:
        int[] dp2 = new int[W];
        for(int i = 1;i<=n;i++){
            for(int j = W;j>=w[i];j--){
                dp2[j] = Math.max(dp2[j],dp2[j-w[i]] + v[i]);
            }
        }
    }

    /**
     * 完全背包
     *
     * 问题描述：
     *
     * 有n类重量为w[i]的物品，各自的价值为v[i],每一类有无限个，现在有一个容量为W的背包
     * 需要选择一些物品放入背包里面，使得物品重量总和小于等于W，并且价值总和最大
     * 问最大价值是多少
     *
     * 解法：
     *
     *  同0-1背包类似， 用dp[i][j] 来表示从前i个物品中，选取总重量为j的物品所能够得到的最大价值
     *
     *     对于状态dp[i][j] 来说一共有两种状态，分别为:
     *      1.不取w[i]的物品(w[i] >=j >=0) dp[i][j] = dp[i-1][j]
     *      2.取w[i]的物品，因为数量是无限的，我们假设取的个数为k (j >= k*w[i])
     *          此时的状态状态方程为 dp[i][j] = max(dp[i-1][j-k*w[i]] + k*v[i]) ( j/w[i] >= k >= 1)
     *
     *     上述两个状态可以合并为一个:
     *
     *     0. dp[i][j] = max(dp[i-1][j-k*w[i]] + k*v[i]) (j/w[i] >= k >= 0)
     *
     *     这样的话写出来的状态转移方程就会包含3重循环，复杂度有点高，需要尝试优化一下
     *
     *     第一次优化我们去掉一些重复计算的项：
     *          由上面的转移方程0进行变换之后我们可以得到如下的式子：
     *
     *          1. dp[i][j-w[i]] = max(dp[i-1][j-(k+1)*w[i]] + k*v[i]) ,假定(k+1) = k'，则
     *
     *          2. dp[i][j-w[i]] = max(dp[i-1][j-k'*w[i]] +(k'- 1)*v[i] )  (j/w[i] >= k' >= 1)
     *
     *          3. dp[i][j-w[i]] + v[i] = max(dp[i-1][j-k'*w[i]] +k'*v[i]) (j/w[i] >= k' >= 1 )
     *
     *     式子0可以写作两部分；
     *
     *          4. dp[i][j] = dp[i-1][j]   ( k == 0)
     *          5. dp[i][j] = max(dp[i][j],dp[i-1][j-k*w[i]] + k*v[i]) (j/w[i] >= k >= 1)
     *
     *     而式子3和式子5的右半部分其实是一致的，也就是说式子5也可以写作：
     *
     *          6. dp[i][j] = dp[i][j-w[i]] + v[i] (j/w[i] >= k >= 1)
     *     所以最终的转移方程为：
     *
     *          dp[i][j] = max(dp[i-1][j],dp[i][j-w[i]]+v[i])
     *
     *
     *
     */
    private void solution2(){
        int n,W;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        W = scanner.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for(int i = 0;i<n;i++){
            w[i] = scanner.nextInt();
        }
        for(int i = 0;i<n;i++){
            v[i] = scanner.nextInt();
        }
        int[][] dp = new int[n+1][W+1];
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=W;j++){
                if(j < w[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-w[i]] + v[i]);
                }
            }
        }
        //由于状态转移方程中只涉及到i和i-1这两个状态，因此该状态转移方程还可以优化一下:
        int[] dp2 = new int[W];
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=W;j++){
                if(j < w[i]){
                    dp2[j] = dp2[j];
                }else{
                    dp2[j] = Math.max(dp2[j],dp2[j-w[i]] + v[i]);
                }
            }
        }
        //再次优化后为:
        for (int i = 1; i <= n; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp2[j] = Math.max(dp2[j], dp2[j - w[i]] + v[i]);
            }
        }

    }

    /**
     * 多重背包
     *
     * 问题描述：
     *
     * 有n类重量为w[i]的物品，各自的价值为v[i],每一类有m[i]个，现在有一个容量为W的背包
     * 需要选择一些物品放入背包里面，使得物品重量总和小于等于W，并且价值总和最大
     * 问最大价值是多少
     *
     * 解法：
     *
     *  同0-1背包类似，我们先用dp[i][j] 来表示从前i个物品中，选取总重量为j的物品所能够得到的最大价值，然后我们来推状态转移方程
     *  很轻松就能得到：
     *
     *  0. dp[i][j] = max(dp[i-1][j - k*w[i]] + k*v[i]) ( min(j/w[i],m[i]) >= k >=0)
     *
     *  如果 m[i] * w[i] >= j，则同完全背包完全一致
     *
     *      1. dp[i][j] = max(dp[i-1][j],dp[i][j-w[i]]+v[i])
     *  如果 m[i] * w[i] < j,则
     *      2. dp[i][j] = max(dp[i-1][j - k*w[i]] + k*v[i]) ( m[i] >= k >=0)
     *
     */
    private void solution3(){

    }

}


