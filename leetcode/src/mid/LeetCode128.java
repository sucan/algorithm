package mid;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: kep
 * @Date: 2022/7/23 13:45
 * @Description:
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int num:nums){
            numSet.add(num);
        }
        int ans = 0;
        for(int num:nums){
            if(!numSet.contains(num-1)){
                int length = 1;
                int tmp = num;
                while(numSet.contains(tmp+1)){
                    length++;
                    tmp++;
                }
                if(ans < length){
                    ans = length;
                }
            }
        }
        return ans;
    }
}
