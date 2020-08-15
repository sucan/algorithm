package educationalCodeforcesRound93;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/14 11:38 PM
 */
public class GoodSubarrays {
    private static int[] count = new int[2000005];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            init(n);
            String s = scanner.next();
            long ans = 0;
            count[n]++;
            int sum = 0;
            for(int i = 1;i<=n;i++){
                sum = sum + Integer.valueOf(s.charAt(i-1) +"");
                int tmp = sum - i + n;
                count[tmp]++;
                ans += count[tmp] -1;
            }
            System.out.println(ans);
        }

    }

    private static void init(int n){
        for(int i = 0;i<n*10;i++){
            count[i] = 0;
        }
    }
}
