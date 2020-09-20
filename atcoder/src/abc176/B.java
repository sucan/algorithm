package abc176;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/10 10:58 下午
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        long sum = 0;
        int length = s.length();
        for(int i = 0;i<length;i++){
            sum += (s.charAt(i)-'0');
        }
        System.out.println(sum % 9==0?"Yes":"No");
    }
}
