package educationalround92;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/1 2:30 PM
 * codeforces link:https://codeforces.com/problemset/problem/1389/A
 */
public class LCMProblem {

    /**
     *
     * 由题意可知x和y的关系为 x*k = y (k > 1)
     * 而 x 的取值为 x >= l x<= r
     * 因此y 的取值为 y >= 2*x y <= r
     * 因此最小的一对满足条件的<x,y> 的取值为<l,2*l>
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
