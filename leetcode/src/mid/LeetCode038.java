package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/27 00:28
 * @Description:
 */
public class LeetCode038 {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        return convert(countAndSay(n-1));
    }
    public  String convert(String value){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char tmp = value.charAt(0);
        for(int i = 1;i<value.length();i++){
            if(value.charAt(i) != tmp){
                sb.append(count);
                sb.append(tmp);
                count = 1;
                tmp = value.charAt(i);
            }else {
                count++;
            }
        }
        sb.append(count);
        sb.append(tmp);
        return sb.toString();
    }
}
