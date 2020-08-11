package DP;
import java.util.Scanner;

/**
 * 多重部分和问题
 * Created by enpingkuang on 2020/8/2 1:05 AM
 */
public class PartialSums {
    private static int[][] dp = new int[300001][300001];
    private static int[] w = new int[300001];
    private static int[] m = new int[300001];
    private static final int INF = Integer.MAX_VALUE;

    /**
     *  dp[i+1][j] 表示用前i种物品组成重量为j的时候，第i种物品最多能剩多少个，如果不能到达则为-1；
     *
     *  dp[i+1][j] = m[i] (dp[i][j] >= 0 )
     *  dp[i+1][j] = -1   (dp[i+1][j - a[i]] == -1 || j < a[i])
     *  dp[i+1][j] = dp[i+1][j-a[i]] + 1
     *  
     *  可以压缩数组进行优化
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int W = scanner.nextInt();
        init(n,W);
        for(int i = 0;i<n;i++){
            w[i] = scanner.nextInt();
        }
        for(int i = 0;i<n;i++){
            m[i] = scanner.nextInt();
        }
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=W;j++){
                if (dp[i-1][j] >= 0){  //dp[j] >= 0
                    dp[i][j] = m[i];
                }else if(j<w[i] || dp[i][j-w[i]] == -1){  //j < w[i] || dp[j-w[i]] == -1
                    dp[i][j] = -1;
                }else{
                    dp[i][j] = dp[i][j-w[i]] - 1;
                }
            }
        }
        System.out.println(dp[n][W] >= 0);
    }


    private static void init(int n,int W){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=W;j++) {
                dp[i][j] = -1;
            }
        }
    }
}
