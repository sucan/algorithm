package abc179;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/20 2:31 下午
 */
public class E {
    private static int MOD = 998244353;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long x = scanner.nextLong();
        long m = scanner.nextLong();
        for(int i = 0;i<50;i++){
            System.out.println(x);
            x = (x*x)%m;
        }
    }
}
