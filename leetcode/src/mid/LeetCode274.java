package mid;

import java.util.Arrays;

/**
 * @Auther: kep
 * @Date: 2023/8/5 19:44
 * @Description:
 */
public class LeetCode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int numbers = citations.length;
        for(int i = 0;i<citations.length;i++){
            if(citations[i] >= numbers){
                return numbers;
            }
            numbers--;
        }
        return 0;
    }
}
