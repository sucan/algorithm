package abc177;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/10 10:58 下午
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        int ans = 10000;
        for(int i = 0;i<=s.length()-t.length();i++){
            int x = 0;
            for(int j = 0;j<t.length();j++){
                if(s.charAt(i+j) != t.charAt(j)){
                    x++;
                }
            }
            ans = Math.min(ans,x);
        }
        System.out.println(ans);
    }
}
