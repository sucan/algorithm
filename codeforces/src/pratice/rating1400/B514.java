package pratice.rating1400;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B514 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Double x = scanner.nextDouble();
        Double y = scanner.nextDouble();
        boolean[] vis = new boolean[n];

        Double[] tmp_x = new Double[n];
        Double[] tmp_y = new Double[n];
        int ans = n;
        for(int i = 0;i<n;i++){
             tmp_x[i] = scanner.nextDouble();
             tmp_y[i] = scanner.nextDouble();
        }
        for(int i = 0;i<n;i++){
            if(vis[i]){
                continue;
            }
            for(int j = i+1;j<n;j++){
                if(vis[j]){
                    continue;
                }
                if((tmp_y[i] -y)*(tmp_x[j]-x) == (tmp_y[j] -y)*(tmp_x[i]-x)){
                    vis[i] = true;
                    vis[j] = true;
                    ans--;
                }
            }
        }
        System.out.println(ans);
    }
}
