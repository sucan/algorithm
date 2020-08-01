package educationalround92;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/1 2:30 PM
 * codeforces link:https://codeforces.com/problemset/problem/1389/A
 */
public class LCMProblem {

    /**
     *  lcm(x,y) = x*y/gcd(x,y)
     *
     * 1. x和某个数的最小公倍数一定等于 x*k (k >= 1)
     * 2. 由题意知另一个数一定是大于x的，所以此处k的取值范围应该是(k >= 2)
     * 3. 由k的取值范围计算出最小公倍数的取值范围： x*2,x*3,x*4,.......x*n 是一个单调递增数列
     * 4. 从上面的数列里面随便选一个有解的就行,而只要 l*2 <= r 则一定有解为 (l,2*l),并且也为最小解
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if(l*2 > r){
                System.out.println("-1 -1");
            }else{
                System.out.println(String.format("%d %d",l,2*l));
            }
        }
    }


}
