package abc176;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/10 10:54 下午
 */
public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int t = scanner.nextInt();
        int flag = n % x == 0?0:1;
        System.out.println((n/x + flag)*t);
    }
}
