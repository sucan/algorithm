package pratice.rating1400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目等同于把n个数划分为k份，然后每一份里面真正有意义的只有最大值和最小值
 * 我们要使得 最大值加最小值得和最大，很容易想到的思路是令每一份数里面的最小值最大，同时最大值尽可能大
 *
 * 1. 由于sigma(k) = n,所以每一个数都会被用到，也就是说数组中的最小值一定会在某一份数里面被计数一次
 * 2. 在最小值已经明确的情况下我们要使得同一份数里面的最大值尽可能大，因此当前剩余数字中的最大值和最小值一定会出现在一起
 * 3. 那么对于第i个朋友而言剩余可获得的数字个数为：w[i] -2 ,对于这些数字我们直接从小到大按序填充即可
 * 4. 由上面的方法可以，每次消除掉的数越多，后面能够得到的和就最大，因此我们需要按照降序来对w进行排序，并按照顺序进行填充
 * ps:对于w[i] = 1的情况，直接填充最大值即可
 *
 */
public class C1369 {
    private static final int MAX_N = 200001;
    private static Integer[] a = new Integer[MAX_N];
    private static Integer[] w = new Integer[MAX_N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
            }
            for(int i = 0;i<k;i++){
                w[i] = scanner.nextInt();
            }
            Arrays.sort(a,0,n);
            Arrays.sort(w, 0, k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            long ans = 0;
            int index_w = k-1;
            int l = 0,r = n-1;
            while(index_w >=0 && w[index_w--] == 1){
                ans += 2*a[r--];
            }
            index_w = 0;
            while(l < r){
                ans = ans + a[r--] + a[l];
                l += w[index_w++]-1;
            }
            System.out.println(ans);
        }
    }
}
