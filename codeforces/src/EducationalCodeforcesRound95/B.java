package EducationalCodeforcesRound95;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/14 10:31 下午
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[105];
            int[] b = new int[105];
            int[] l = new int[105];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                l[i] = scanner.nextInt();
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (l[i] == 0) {
                    b[cnt++] = a[i];
                }
            }
            Arrays.sort(b,0,cnt);
            for(int i=0 ;i<cnt/2;i++){
                int tmp = b[i];
                b[i] = b[cnt-1-i];
                b[cnt-1-i] = tmp;
            }
            int w = 0;
            for (int i = 0; i < n; i++) {
                if (l[i] == 0) {
                    System.out.print(b[w++] + " ");
                } else{
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
