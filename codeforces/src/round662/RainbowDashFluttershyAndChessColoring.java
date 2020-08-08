package round662;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/8 12:53 PM
 */
public class RainbowDashFluttershyAndChessColoring {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t;
        t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            System.out.println(n/2 +1);
        }
    }
}
