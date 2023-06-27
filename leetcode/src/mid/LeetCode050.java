package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:24
 * @Description:
 */
public class LeetCode050 {
    public  double myPow(double x, int n) {
        long tmpn = n;
        if(tmpn == 0){
            return 1D;
        }
        boolean flag = tmpn < 0;
        tmpn = tmpn<0?-tmpn:tmpn;
        if(flag){
            return 1/fasterPow(x,tmpn);
        }
        return fasterPow(x,tmpn);
    }

    public  double fasterPow(double x, long n){
        double result = 1 ;
        double tmp = x;
        while(n > 0){
            if((n & 1) == 1){
                result*=tmp;
            }
            tmp *= tmp;
            n>>=1;
        }
        return result;
    }
}
