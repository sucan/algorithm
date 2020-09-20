package abc179;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/19 7:53 下午
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long dp[] = new long[1000006];
        for(int i = 1;i<1000006;i++){
            for(int j = 1;j*i<1000006;j++){
                dp[j*i]++;
            }
        }
        long ans = 1;
        for (int i = 2; i < n; i++) {
            ans += dp[i];
        }
        System.out.println(ans);
    }
}
