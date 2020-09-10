package abc177;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/10 10:54 下午
 */
public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        double t = scanner.nextDouble();
        double s = scanner.nextDouble();
        System.out.println(d/s <= t?"Yes":"No");
    }
}
