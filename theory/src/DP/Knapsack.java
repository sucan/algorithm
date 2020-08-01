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
     *
     */
    private void solution2(){

    }

    /**
     * 多重部分和
     */
    private void solution3(){

    }

}


