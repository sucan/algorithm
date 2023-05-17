package mid;

/**
 * @Auther: kep
 * @Date: 2023/5/17 22:34
 * @Description:
 */
public class LeetCode151 {
    public String reverseWords(String s) {
        if(s.length() == 0){
            return "";
        }
        int l = -1,r = s.length();
        for(int i = 0;i<s.length();i++){
            if(l == -1 && ' ' != s.charAt(i)){
                l = i;
            }
            if(l != -1 && ' ' == s.charAt(i)){
                r = i;
                break;
            }
        }
        if(l == -1){
            return "";
        }
        String  firstWord = s.substring(l,r);
        String prefix = reverseWords(r == s.length() || r == s.length()-1?"":s.substring(r+1));
        if(prefix.length() > 0){
            return prefix + " " + firstWord;
        }else{
            return firstWord;
        }
    }

    public static void main(String[] args) {
        new LeetCode151().reverseWords("the sky is blue");
    }
}
