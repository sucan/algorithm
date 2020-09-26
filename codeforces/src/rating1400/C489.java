package rating1400;

import java.util.Scanner;

public class C489 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        int tmp_min = s;
        int tmp_max = s;
        if(s == 0 && m == 1){
            System.out.println("0 0");
            return;
        }
        for(int i = 0;i<m;i++){
            for(int j = 9;j>=0;j--){
                if(i == 0 && j == 0){
                    continue;
                }
                if(tmp_max >= j){
                    max.append(j);
                    tmp_max-=j;
                    break;
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<=9;j++){
                if(i == 0 && j ==0){
                    continue;
                }
                if((m-i-1)*9 >= tmp_min-j){
                    min.append(j);
                    tmp_min-=j;
                    break;
                }
            }
        }
        if(tmp_max != 0 || tmp_min !=0){
            System.out.println("-1 -1");
        }else{
            System.out.printf(min.toString() + " " + max.toString());
        }
    }
}
