package EducationalCodeforcesRound95;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/14 10:31 下午
 */
public class C {
    private static  int[] a = new int[200005];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            init(n);
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
            }
            int ans = 0;
            boolean flag = false;
            for(int i = 0;i<n;i++){
                if(!flag){
                    if(a[i] == 1)ans++;
                    if(a[i+1] == 0 && a[i+2] == 1)i++;
                }else{
                    if(a[i+1] == 1)i++;
                }
                flag = !flag;
            }
            System.out.println(ans);
        }
    }

    private static void init(int n){
        for(int i = 0;i<n+2;i++){
            a[i] = 0;
        }
    }
}
