package round672;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/24 10:34 下午
 */
public class A {
    private static final int MAX_N = 50001;
    private static long[] a = new long[MAX_N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t =scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            boolean flag = false;
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextLong();
                if(i != 0 && a[i] >= a[i-1]){
                    flag = true;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }
}
