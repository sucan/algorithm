package pratice.rating1400;

import java.io.*;

/**
 *
 * 官方题解：
 *
 * LCM(a,b) = a*b/Gcd(a,b)
 *
 * gcd(a,b) 的含义也就是a和b所有的公共质因子的乘积
 * 所以LCM(a,b) = (pow(pa[1],x1).....*pow(pa[ka],xka)) * ( pow(pb[1],xb1).....*pow(pb[kb],xkb))
 * pa 和 pb 都为质数,并且pa和pb中没有任何一个重复的
 *
 * 同时LCM(a,b) = x，对x做一遍质因数分解之后，就能够得到类似 X = pow(px[1],x1).....*pow(px[ka],xka) 的表达式
 *
 * 因此只需要枚举把px分为两组的所有情形就能得到答案。
 *
 * 真实解法：
 * 因为此题规模不大，同时有LCM(a,b) 一定能够整除a，b,换而言之a，b的所有组合一定是LCM(a,b)的约数
 * 因此只需要枚举x的所有约数，然后判断 LCM(a,x/a) 是否等于x即可
 *
 *
 * 这类gcd和lcm相关的题目，一定要思考清楚质因数分解后的情形，想明白gcd本质就是两数相同质因数乘积
 *
 */
public class C1285 {
    private static final int MAX_N = 1000000;
    private static Integer[] prime = new Integer[MAX_N+1];
    private static boolean[] primeVis = new boolean[MAX_N+1];
    private static int primeIndex  = 0;

    static class InputSupport{
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer getInt() throws Exception {
            return Integer.valueOf(br.readLine());
        }

        Integer[] getIntArray(int n) throws Exception {
            String s = br.readLine();
            Integer[] result = new Integer[n];
            String[] strings = s.split(" ");
            for(int i = 0;i<n;i++){
                result[i] = Integer.valueOf(strings[i]);
            }
            return result;
        }

        Long getLong() throws Exception {
            return Long.valueOf(br.readLine());
        }

        Long[] getLongArray(int n) throws Exception {
            String s = br.readLine();
            Long[] result = new Long[n];
            String[] strings = s.split(" ");
            for(int i = 0;i<n;i++){
                result[i] = Long.valueOf(strings[i]);
            }
            return result;
        }

        Double getDouble() throws Exception {
            return Double.valueOf(br.readLine());
        }

        Double[] getDoubleArray(int n) throws Exception {
            String s = br.readLine();
            Double[] result = new Double[n];
            String[] strings = s.split(" ");
            for(int i = 0;i<n;i++){
                result[i] = Double.valueOf(strings[i]);
            }
            return result;
        }

    }

    public static void main(String[] args) throws Exception {
        InputSupport inputSupport = new InputSupport();
        primeInit(1000000);
        long x = inputSupport.getLong();
        long a = 1,b = x;
        long ans = Math.max(a,b);
        for(long i = 1;i*i<x;i++){
            if (x % i == 0 && i*(x/i)/gcd(i,x/i) == x) {
                long tmp = Math.max(i, x / i);
                if (tmp < ans) {
                    ans = tmp;
                    a = i;
                    b = x / i;
                }
            }
        }
//        System.out.println(ans);
        System.out.println(a+" "+b);
    }

    private static long gcd(long a,long b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }

    private static void primeInit(int max){
        for(int i = 2;i<=max;i++){
            if(!primeVis[i]){
                prime[primeIndex++] = i;
            }
            for(int j = 2;j*i<=max;j++){
                primeVis[i*j] = true;
            }
        }
    }
}

