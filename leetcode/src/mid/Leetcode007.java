package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/12 22:45
 * @Description:
 */
public class Leetcode007 {
    public int reverse(int x) {
        int flag = -1;
        if(x < 0){
            flag = 1;
        }
        x = Math.abs(x);
        long coefficient = 1;
        long tmp = x;
        while(tmp >= 10){
            coefficient *=10;
            tmp/=10;
        }
        long ans =  -1 * flag * reverse(x,coefficient);
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return 0;
        }
        return (int)ans;
    }

    private long reverse(long x,long coefficient){
        if(x < 10){
            return x;
        }
        long number = x%10;
        return number*coefficient + reverse(x/10,coefficient/10);
    }
}
