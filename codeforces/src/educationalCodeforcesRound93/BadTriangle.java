package educationalCodeforcesRound93;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/14 10:35 PM
 */
public class BadTriangle {

    private static long[] a = new long[100005];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
            }
            if(a[0] + a[1] > a[n-1]){
                System.out.println("-1");
            }else{
                System.out.println("1 2 "+n);
            }

        }

    }
}
