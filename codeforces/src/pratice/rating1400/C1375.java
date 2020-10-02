package pratice.rating1400;

import java.util.Scanner;

public class C1375 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            Integer[] a = new Integer[n];
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
            }
            if(a[0] < a[n-1]){
                System.out.println("YES");
            }else{
                System.out.println("No");
            }
        }
    }
}
