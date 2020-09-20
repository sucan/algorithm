package abc175;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/20 11:36 下午
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long k = scanner.nextLong();
        long d = scanner.nextLong();
        x = Math.abs(x);
        long n = x/d;
        if(x%d !=0)n++;
        if(n > k){
            System.out.println(x-k*d);
        }else{
            long tmp = k - n;
            if(tmp % 2 == 1){
                System.out.println(x - (n-1)*d);
            }else{
                System.out.println(Math.abs(x-n*d));
            }
        }
    }
}
