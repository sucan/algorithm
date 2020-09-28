package pratice.rating1400;

import java.util.Arrays;
import java.util.Scanner;

public class C515 {
    private static final int MAX_N = 100001;
    private static final int A[][] = {{},{},{2},{3},{2,2,3},{5},{3,5},{7},{2,2,2,7},{2,3,3,7}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = new int[100];
        int index = 0;
        String a = scanner.next();
        for(int i = 0;i<n;i++){
            int tmp = a.charAt(i)-'0';
            if(A[tmp].length > 0){
                for(int j = 0;j<A[tmp].length;j++){
                    ans[index++] = A[tmp][j];
                }
            }
        }
        Arrays.sort(ans,0,index);
        for(int i = index-1;i>=0;i--){
            System.out.print(ans[i]);
        }
        System.out.println();
    }
}
