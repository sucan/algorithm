package abc245;

import java.util.Scanner;

/**
 * @Auther: kep
 * @Date: 2022/6/28 23:40
 * @Description:
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            for(int j = i;j>=0;j--){
                if(j == 0 || j == i){
                    a[j] = 1;
                }else{
                    a[j] = a[j] + a[j-1];
                }
            }
            for(int j = 0;j<=i;j++){
                if(j == 0){
                    System.out.print(a[j]);
                }else{
                    System.out.print(" "+a[j]);
                }
            }
            System.out.println();
        }
    }
}
