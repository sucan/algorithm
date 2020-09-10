package abc177;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/10 11:18 下午
 */
public class C {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 0;
        long[] sum = new long[n+1];
        for(int i = 1;i<=n;i++){
            int tmp = scanner.nextInt();
            sum[i] = (sum[i-1] + tmp)%MOD;
            ans = (ans + (sum[i-1]*tmp) % MOD)%MOD;
        }
        System.out.println(ans);
    }
}
