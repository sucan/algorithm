package round672;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/24 11:09 下午
 */
public class B {

    private static final int MAX_N = 500001;
    private static long[] a = new long[MAX_N];
    private static long[] num = new long[MAX_N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t =scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            long[] num = new long[100];
            long ans = 0;
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextLong();
                int index = 0;
                while(a[i] != 0){
                    a[i] >>= 1;
                    index++;
                }
                num[index]++;
                ans += num[index] - 1;
            }
            System.out.println(ans);
        }
    }
}
