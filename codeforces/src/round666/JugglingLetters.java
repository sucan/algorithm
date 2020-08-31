package round666;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/30 10:41 PM
 */
public class JugglingLetters {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n  = scanner.nextInt();
            int[] count = new int[100];
            for(int i = 0;i<n;i++){
                String tmp = scanner.next();
                for(int j = 0;j<tmp.length();j++){
                    int x = tmp.charAt(j) - 'a';
                    count[x]++;
                }
            }
            boolean flag = true;
            for(int i = 0;i<26;i++){
                if(count[i] % n != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
