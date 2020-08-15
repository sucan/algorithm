package educationalCodeforcesRound93;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/14 10:46 PM
 */
public class SubstringRemovalGame {

    private static int[] a = new int[101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int index = 0;
            int[] a = new int[101];
            String s = scanner.next();
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == '1'){
                    a[index]++;
                }else if(i!= 0 && s.charAt(i-1) == '1'){
                    index++;
                }
            }
            Arrays.sort(a);
            int ans = 0;
            for(int i = 100;i>=0;i--){
                if(a[i] == 0){
                    break;
                }
                if(i%2 == 0){
                    ans+=a[i];
                }
            }
            System.out.println(ans);
        }

    }
}
