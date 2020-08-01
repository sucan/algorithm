package round660;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/1 2:36 PM
 */
public class CaptainFlintAndCrewRecruitment {
    /**
     * 质数列表为：2,3,5,7,11,......
     * 相邻数的乘积按照大小排序为: 6,10,14,15,21,22,33,......
     * 因此3个相邻数相加最小的和为 6+10+14 = 30
     * 因此如果n小于30则无解，大于30则需要特判 n - 30 等于6，10，14的场景，其他情况一定有解
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t;
        t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            if (n > 30) {
                System.out.println("YES");
                int tmp = n - 30;
                if (tmp == 6 || tmp == 10 || tmp == 14) {
                    if (tmp == 6) {
                        System.out.println("5 6 10 15");
                    } else if (tmp == 10) {
                        System.out.println("22 6 10 2");
                    } else {
                        System.out.println("6 7 10 21");
                    }
                } else {
                    System.out.print("6 10 14 ");
                    System.out.println(n - 30);
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
