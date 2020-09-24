package abc175;

import java.util.Scanner;

/**
 * 暴力枚举起点，最终的路径一定是一个环，然后我们对于每一个环做如下操作：
 *
 * 如果环的边数大于等于k，那么就计算走 <= k步时能取到的最大值
 *
 * 如果环的边数小于k，并且走完这个环的总花费为正数，那么就取 在环上走 <= k 步时能取到的最大值 + 走到当前节点时最多能走几遍整个环 * 走完这个环的总花费
 *
 * Created by enpingkuang on 2020/9/23 11:27 下午
 */
public class D {
    private static final int MAX_N = 50005;
    private static long[] cycleSum = new long[MAX_N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] p = new int[MAX_N];
        long[] c = new long[MAX_N];
        for(int i = 1;i<=n;i++){
            p[i] = scanner.nextInt();
        }
        for(int i =1;i<=n;i++){
            c[i] = scanner.nextLong();
        }
        long ans = Long.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            int start = i;
            int cycleCount = 0;
            for(;;){
                int next = p[start];
                cycleCount++;
                cycleSum[cycleCount] = cycleSum[cycleCount-1] + c[next];
                if(next == i){
                    break;
                }
                start = next;
            }
            start = i;
            for(long index = 1;index<=cycleCount;index++){
                int next = p[start];
                if(index <= k){
                    ans = Math.max(ans,cycleSum[(int)index]);
                    if(cycleSum[cycleCount] > 0) {
                        ans = Math.max(ans, cycleSum[(int)index] + cycleSum[cycleCount] *((k-index)/cycleCount));
                    }
                }
                if(next == i){
                    break;
                }
                start = next;
            }
        }
        System.out.println(ans);
    }
}
