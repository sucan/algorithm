package abc245;

import java.util.Scanner;

/**
 * @Auther: kep
 * @Date: 2022/6/28 23:26
 * @Description:
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n%100 < 10){
            System.out.print("0");
        }
        System.out.println(n%100);
    }
}
