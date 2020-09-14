package abc178;

import java.util.*;

/**
 * Created by enpingkuang on 2020/9/13 8:54 下午
 */
public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 0;
        long[] max = new long[4];
        long[] min = new long[4];
        for(int i = 0;i<4;i++){
            max[i] = Long.MIN_VALUE;
            min[i] = Long.MAX_VALUE;
        }
        for(int i = 0;i<n;i++){
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            for(int j = 0;j<4;j++){
                long tmp_x = (j >> 1) == 1?-x:x;
                long tmp_y = (j & 1) == 1?-y:y;
                long tmp = tmp_x + tmp_y ;
                min[j] = Math.min(min[j],tmp);
                max[j] = Math.max(max[j],tmp);
                ans = Math.max(ans,max[j]-min[j]);
            }
        }
        System.out.println(ans);
    }
}
