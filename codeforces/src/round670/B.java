package round670;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/12 9:56 下午
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[] a = new long[100005];
        while (t-- > 0) {
            int n = scanner.nextInt();
            for(int i =0;i<n;i++){
                a[i] = scanner.nextLong();
            }
            Arrays.sort(a,0,n);
            long ans = 0;
            for(int i = 0;i <= 5;i++){
                long sum = 1;
                for(int j = 0;j<i;j++){
                    sum *= a[j];
                }
                for(int j = n-1;j>n-1-5+i;j--){
                    sum *= a[j];
                }
                if(i == 0){
                    ans = sum;
                }else{
                    ans = Math.max(ans,sum);
                }
            }
            System.out.println(ans);
        }
    }
}
