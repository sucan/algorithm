/**
 * @Auther: kep
 * @Date: 2023/8/13 18:28
 * @Description:
 */
public class Debug {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int x = a.length() - b.length();
        for(int i = 0;i<x;i++){
            b = '0' + b;
        }
        int flag = 0;
        for(int i = a.length()-1;i>=0;i--){
            int aNum = a.charAt(i) - '0';
            int bNum = b.charAt(i) - '0';
            int num = aNum + bNum + flag;
            if(num > 1){
                flag = 1;
            }else{
                flag = 0;
            }
            ans.append((char)('0' + num%2));
        }
        if(flag != 0){
            ans.append('1');
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        new Debug().addBinary("1","111");
    }

}
