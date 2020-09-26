package rating1400;

import java.util.Scanner;

public class A698 {
    private static final int MAX_N = 105;
    private static int[] a = new int[MAX_N];
    private static int[][] dp = new int[MAX_N][4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        init(n);
        for(int i = 1;i<=n;i++){
            a[i] = scanner.nextInt();
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1;i<=n;i++){
            if(dp[i - 1][1] != Integer.MAX_VALUE && (a[i] == 1 || a[i] == 3)) {
                dp[i][1] = min(dp[i][1], dp[i - 1][1]+1);
            }
            if(dp[i - 1][2] != Integer.MAX_VALUE && (a[i] == 2 || a[i] == 3)){
                dp[i][2] = min(dp[i][2], dp[i - 1][2]+1);
            }
            for(int j = 0;j<3;j++){
                if(dp[i-1][j] != Integer.MAX_VALUE){
                    dp[i][0] = min(dp[i-1][j]+1,dp[i][0]);
                    if(j != 1 && (a[i] == 1 || a[i] == 3)) {
                        dp[i][1] = min(dp[i][1], dp[i - 1][j]);
                    }
                    if(j != 2 && (a[i] == 2 || a[i] == 3)){
                        dp[i][2] = min(dp[i][2], dp[i - 1][j]);
                    }
                }
            }
        }
        System.out.println(min(dp[n][0],dp[n][1],dp[n][2]));
    }


    public static void init(int n){
        for(int i =1;i<=n;i++){
            dp[i][1] = dp[i][2] = dp[i][0] = Integer.MAX_VALUE;
        }
    }

    public static int min(Integer ... a){
        int ans = Integer.MAX_VALUE;
        for(int tmp:a){
            ans = Math.min(ans,tmp);
        }
        return ans;
    }
}
