package abc178;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/12 7:58 下午
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int right = 1;
        int[] ans = new int[h+1];
        for(int i = 1;i<=h;i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if(right < l){
                ans[i] = ans[i-1] + 1;
            }else{
                int tmp = Math.max(r + 1, right);
                if(tmp <= w){
                    if(i != 1) {
                        ans[i] = ans[i - 1] + 1 + tmp - right;
                    }else{
                        ans[i] = 1;
                    }
                    right = tmp;
                }else{
                    ans[i] = -1;
                }
            }
            System.out.println(ans[i]);
        }
    }
}
