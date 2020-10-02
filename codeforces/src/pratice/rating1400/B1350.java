package pratice.rating1400;

import java.util.Scanner;

public class B1350 {
    private static final int MAX_N = 200001;
    private static Integer[] a = new Integer[MAX_N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int[] dp = new int[n+1];
            for(int i = 1;i<=n;i++){
                a[i] = scanner.nextInt();
                dp[i] = 1;
            }
            int ans = 0;
            for(int i = 1;i<=n;i++){
                for(int j = 1;j*j<=i;j++){
                    if(i%j == 0){
                        if(a[i] > a[j]) {
                            dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                        if(a[i] > a[i/j]) {
                            dp[i] = Math.max(dp[i], dp[i / j] + 1);
                        }
                    }
                }
                ans = Math.max(ans,dp[i]);
            }
            System.out.println(ans);
        }
    }
}
