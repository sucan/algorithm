package pratice.rating1400;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 这道题比较有意思，我的思路是先算出数组里面每一个数最少需要加多少才能够整除k
 * 例如样例1，按照上面的逻辑处理之后的数组就为：[2,1,2,0] ，我们令该数组为b，b数组的含义如下：
 *
 * a[0] 需要加上 b[0] + x * k (x >=0 ) 才能被3整除
 * a[1] 需要加上 b[1] + x * k (x >=0 ) 才能被3整除
 * a[2] 需要加上 b[2] + x * k (x >=0 ) 才能被3整除
 * a[3] 可以被3整除
 *
 * 其中原本就能被整除的数可以直接忽略掉，只需要关注后续的数
 *
 * 我们先把 a[0]~a[2] 可能的取值展开
 *
 * a[1]:1 4 7 10 ......
 * a[0]:2 5 8 11 ......
 * a[2]:2 5 8 11 ......
 *
 * a[0] = a[2] 出现了2次，因此满足条件的最小值为数列第二位，也就是5
 * a[1] 只出现了一次，因此满足条件的最小值为数列第一位，也就是1
 *
 * 观察上面的数列我们能得到一个结论： 假设b[i]出现了n次，那么至少需要取到的x值为b[i]+ (n-1)*k +1，也就是上面数列的第n项
 * 同时由于b数组中都是小于k的数，所以只要某一个数出现次数最大，那么它需要的x就一定最大，同时它取到的x值一定能够覆盖掉其他所有数，因为x是公差为1的等差数列，会取到所有的自然数，自然包含所有比x小的数
 *
 * 所以我们只需要找出现次数最多的b[i](若出现次数相同则找b[i]较大的那个)，b[i]+ (n-1)*k +1 就是我们需要的答案
 *
 *
 *
 */
public class D1374 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextInt();
            long max = 0;
            long number = -1;
            Map<Long,Long> map  = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long a = scanner.nextInt();
                if (a % k != 0) {
                    a = (a / k + 1) * k - a;
                    Long times = map.putIfAbsent(a, 0L);
                    times = map.get(a);
                    times++;
                    map.put(a,times);
                    if(times > max){
                        max = times;
                        number = a;
                    }else if(times == max){
                        number = Math.max(a,number);
                    }
                }
            }
            if(max == 0){
                System.out.println(0);
            }else {
                System.out.println(number + 1 + (max - 1) * k);
            }
        }
    }
}
