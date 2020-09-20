package abc176;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/10 11:18 下午
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long max = 0;
        long ans = 0;
        for(int i = 0;i<n;i++){
            int tmp = scanner.nextInt();
            if(tmp < max){
                ans += (max-tmp);
            }else{
                max = Math.max(tmp,max);
            }
        }
        System.out.println(ans);
    }
}
