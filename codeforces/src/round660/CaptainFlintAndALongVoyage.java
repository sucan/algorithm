package round660;

import java.util.Scanner;

/**
 * codeforces link:https://codeforces.com/contest/1388/problem/B
 * Created by enpingkuang on 2020/8/1 3:07 PM
 */
public class CaptainFlintAndALongVoyage {

    /**
     * 0~9 的二进制表示分别为[0,1,10,11,100,101,110,111,1000,1001]
     * 8和9的长度最长为4，因此用8和9来构造数字为最优解
     * 而对于8和9而言，只有当n%4 = 0的时候使用9比使用8得到的结果要大，其他时候用8和用9得到的结果是一样的
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t;
        t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            int tmp = n-n/4;
            for(int i = 0;i<n;i++){
                if (i < tmp) {
                    if (i == tmp - 1 && n % 4 != 0) {
                        sb.append('8');
                    } else {
                        sb.append('9');
                    }
                } else {
                    sb.append('8');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
