package abc178;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/13 8:01 下午
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] a = new long[4];
        long sum = Long.MIN_VALUE;
        for(int i = 0;i<4;i++){
            a[i] = scanner.nextLong();
        }
        sum = Math.max(sum,a[0]*a[2]);
        sum = Math.max(sum,a[0]*a[3]);
        sum = Math.max(sum,a[1]*a[2]);
        sum = Math.max(sum,a[1]*a[3]);
        System.out.println(sum);
    }
}
