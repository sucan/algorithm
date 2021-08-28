/**
 * 题意是不用乘法除法和模运算来实现除法，剩下还能使用的只有加法和减法，以及位运算
 *
 * 一共有两个解法，第一个比较容易想到的解法就是将十进制数转换为二进制数，然后模拟二进制除法得到答案
 * 第二个解法是尺取法枚举：
 * 假定 a/b = c 余数为 n，那么可以得到 如下等式 a = c * b + n （ n < b ）
 * 按照上面的等式，我们可以尺取c，取c值得时候因为不能用乘法，所以c只能为2的倍数
 * 当找到最大的满足c*b < a的c时，答案加c，然后重置 a = a - c*b,c= 0，直至a < b
 *
 * @Auther: kep
 * @Date: 2021/8/25 22:07
 * @Description:
 */
public class LeetCode029 {

    public static int divide(int dividend, int divisor){
        //只有一种情况会有溢出
        if(dividend == (-1 << 31) && divisor == -1){
            return 2147483647;
        }
        //全部转换为负数来计算
        boolean symbol = !((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0));
        dividend = toNegative(dividend);
        divisor = toNegative(divisor);
        if(dividend > divisor) {
            return 0;
        }
        int result = 0;
        while(dividend <= divisor) {
            int index = 0;
            int tmpDivisor = divisor;
            while(dividend <= tmpDivisor && tmpDivisor >= -1073741824) {
                tmpDivisor<<=1;
                ++index;
            }
            if(index == 0){
                result += 1;
                dividend -= tmpDivisor;
            }else {
                result += 1 << (index - 1);
                dividend -= tmpDivisor >> 1;
            }

        }
        if(symbol) result = -result;
        return result;
    }

    public static int toNegative(int x){
        if (x > 0){
            return -x;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.printf(String.valueOf(divide(10,
                3)));
    }
}
