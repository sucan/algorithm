package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/14 22:27
 * @Description:
 */
public class LeetCode028 {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        initNextArray(next,needle);
        for(int i = 0,j = 0;i<haystack.length();){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
            }else if(j == 0){
                i++;
            }else{
                j = next[j];
            }
            if(j == haystack.length()){
                return i-j;
            }
        }
        return -1;
    }

    private void initNextArray(int[] next,String pattern){
        if(next.length > 0) {
            next[0] = -1;
        }
        if(next.length > 1) {
            next[1] = 0;
        }
        int length = pattern.length();
        int j = 0;
        for(int i = 2;i<length;i++){
            while(j !=0 && pattern.charAt(i-1) != pattern.charAt(j)){
                j = next[j];
            }
            if(pattern.charAt(i-1) == pattern.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        new LeetCode028().strStr("mississippi","issip");
    }
}
