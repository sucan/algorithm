package mid;

/**
 * @Auther: kep
 * @Date: 2021/9/6 22:11
 * @Description:
 */
public class LeetCode041 {
    static char[] ans = new char[401];
    static int[] jingWei = new int[401];
    public static String multiply(String num1, String num2) {
        for(int i = 0;i<401;i++){
            ans[i] = '0';
            jingWei[i] = 0;
        }
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int end = 400;
        int current = end;
        for(int i = num1.length()-1;i>=0;i--){
            current = end;
            for(int j = num2.length()-1;j>=0;j--){
                int tmp = (num2.charAt(j)-'0') * (num1.charAt(i)-'0');
                int currentValue = jingWei[current] + tmp%10 + (ans[current]-'0');
                ans[current] = (char)( '0' + currentValue%10);
                jingWei[current] = 0;
                jingWei[current-1] += tmp/10 + currentValue/10;
                current--;
            }
            end--;
        }
        if(jingWei[current]!=0){
            ans[current] += jingWei[current];
            current--;
        }
        return new String(ans,current+1,400-current);
    }


    public static void main(String[] args) {
        System.out.println(multiply("9","99"));
    }
}
