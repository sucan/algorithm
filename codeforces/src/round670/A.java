package round670;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/12 9:51 下午
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int[] count = new int[105];
            int n = scanner.nextInt();
            for(int i =0;i<n;i++){
                int x = scanner.nextInt();
                count[x]++;
            }
            int sum = 0;
            for(int i = 0;i<2;i++){
                for(int j = 0;j<= 100;j++) {
                    if (count[j] == 0){
                        sum+=j;
                        break;
                    }
                    count[j]--;
                }
            }
            System.out.println(sum);
        }
    }
}
