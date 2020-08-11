package DP;

import java.util.Scanner;


/**
 * 最长上升子序列
 * Created by enpingkuang on 2020/8/2 1:07 AM
 */
public class LIS {
  
  private static int[] dp = new int[300001];
    private static int[] a = new int[300001];
    private static final int INF = Integer.MAX_VALUE;

    /**
     *  dp[i] 表示长度为i+1的上升子序列最小的末尾元素，转移方程为：
     *
     *  dp[i] = min(dp[i],a[j]) (a[j] > dp[i-1])
     *
     *  上面的递推式如果要写的话需要用双重循环：i ： 0->n ,j:index(dp[i-1]) ->n,复杂度为o(n*n)
     *  
     *  由递推式可知dp[i] 一定是一个单调递增的数列，因此可以使用二分来进行优化，按照0->n 的顺序来遍历a[j],并且将a[j]插入
     *  dp[i]中
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        init(n);
        for(int i = 0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0;i<n;i++){
            int index = lower_bound(dp,n,a[i]);
            dp[index] = a[i];
        }
        System.out.println(lower_bound(dp,n,INF));
    }

    private static Integer lower_bound(int[] dp,int length,int value){
        int left = 0,right = length;
        while(left < right){
            int mid = (left + right)/2;
            if(dp[mid] < value){
                left = mid + 1;
            }else if(dp[mid] == value){
                right = mid;
            }else if(dp[mid] > value){
                right = mid ;
            }
        }
        return left;
    }

    private static void init(int n){
        for(int i = 0;i<n;i++){
            dp[i] = INF;
        }
    }
}
