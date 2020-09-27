package rating1400;

import java.util.Scanner;

public class B507 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r= scanner.nextDouble();
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double dis =Math.sqrt ((x-x1)*(x-x1) + (y-y1)*(y-y1));
        if(dis == 0){
            System.out.println(0);
        }else if(dis <= 2*r){
            System.out.println(1);
        }else {
            int ans = (int)(dis / (2*r)) ;
            if (2*r * ans  < dis) {
                ans++;
            }
            System.out.println(ans);
        }
    }
}
