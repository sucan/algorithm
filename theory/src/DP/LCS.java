package DP;

import java.util.Scanner;

/**
 * 最长公共子序列问题
 * 问题描述：
 * 给定两个字符串s,t,求它们的最长公共子序列的长度
 *
 * Created by enpingkuang on 2020/8/2 1:06 AM
 */
public class LCS {
    private static int[][] dp = new int[500][500];

    /**
     * 定义dp[i][j]：s1~si 与 t1~tj 的最长公共子序列的长度
     *
     * 当si != tj 的时候 dp[i][j] 可能的取值有 dp[i-1][j] 和 dp[i][j-1]
     * 当 si == tj 的时候 dp[i][j]可能的取值有： dp[i-1][j] 和 dp[i][j-1] 以及 dp[i-1][j-1] + 1
     *
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=t.length();j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }
        System.out.println(dp[s.length()][t.length()]);
    }

}
