package abc179;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/19 7:53 下午
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        int tmp = 0;
        for(int i = 0;i<n;i++){
            int x,y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            if(x == y){
                tmp++;
                ans = Math.max(ans,tmp);
            }else{
                tmp = 0;
            }
        }
        if(ans >= 3){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
