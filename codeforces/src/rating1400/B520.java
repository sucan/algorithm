package rating1400;

import java.util.Scanner;

public class B520 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int m = scanner.nextInt();
        int ans = 0;
        while( m > n){
            if(m % 2 == 0){
                m/=2;
                ans++;
            }else{
                m = (m+1)/2;
                ans+=2;
            }
        }
        ans +=(n-m);
        System.out.println(ans);
    }
}
