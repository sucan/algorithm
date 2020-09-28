package abc174;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int l = 0,r = n-1;
        int ans = 0;
        while(l < r){
            while(r >= 0 && s.charAt(r) == 'W')r--;
            while(l< n && s.charAt(l) == 'R')l++;
            if(l >= r){
                break;
            }
            ans++;
            r--;
            l++;
        }
        System.out.println(ans);
    }
}
