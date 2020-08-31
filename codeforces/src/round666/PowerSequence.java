package round666;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/30 10:48 PM
 */
public class PowerSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for(int i = 0;i<n;i++){
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        long ans = 100000000000000L;
        for(long c = 1;c <= 10000000L;c++){
            long pow = 1;
            long tmp = 0;
            for(int i = 0;i<n;i++){
                tmp += Math.abs(a[i]-pow);
                pow *= c;
                if(tmp > ans || tmp < 0){
                    tmp = -1;
                    break;
                }
            }
            if(tmp != -1) {
                ans = Math.min(ans, tmp);
            }
        }
        System.out.println(ans);
    }
}
