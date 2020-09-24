package abc175;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/23 10:51 下午
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] l = new long[n];
        for(int i = 0;i<n;i++){
            l[i] = scanner.nextLong();
        }
        Arrays.sort(l);
        long ans = 0;
        for(int i = 0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                for(int k = j+1;k<n;k++){
                    if(l[i]+l[j] > l[k] && l[i] != l[j] && l[j] != l[k] && l[i] != l[k]){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }


}
