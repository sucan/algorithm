package EducationalCodeforcesRound95;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/14 10:31 下午
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long x,y,k;
            x = scanner.nextLong();
            y = scanner.nextLong();
            k = scanner.nextLong();
            int flag = ((k * y + k) - 1)%(x - 1) == 0?0:1;
            System.out.println(((k * y + k) - 1)/(x - 1) + flag  + k);
        }
    }
}
