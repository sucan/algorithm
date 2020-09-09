package round669;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/8 11:16 下午
 */
public class BigVova {

    public static int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] vis = new int[n];
            int max_value = 0;
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
                if(a[i] > max_value){
                    max_value = a[i];
                }
            }
            int tmp_gcd = max_value;
            int index = -1;
            for(int i = 0;i<n;i++){
                int max_gcd = 0;
                for(int j = 0 ;j<n;j++){
                    int x = gcd(a[j],tmp_gcd);
                    if(vis[j] != 1 && x > max_gcd){
                        max_gcd = x;
                        index = j;
                    }
                }
                vis[index] = 1;
                tmp_gcd = max_gcd;
                System.out.print(a[index]+" ");
            }
            System.out.println();
        }
    }
}
