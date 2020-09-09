package abc152;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/9 11:58 下午
 */
public class ACORWA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(n == m){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
