package abc175;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/23 10:45 下午
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int ans = 0;
        int tmp = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'R'){
                tmp++;
            }else{
                tmp = 0;
            }
            ans = Math.max(ans,tmp);
        }
        System.out.println(ans);
    }
}
