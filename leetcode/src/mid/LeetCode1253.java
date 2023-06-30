package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/30 19:08
 * @Description:
 */
public class LeetCode1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        for(int num:colsum){
            sum += num;
            if(num == 2){
                lower--;
                upper--;
            }
        }
        if(upper + lower != sum || upper <0 || lower<0){
            return new ArrayList<>();
        }
        List<Integer> first = new ArrayList<>();
        List<Integer> sec = new ArrayList<>();
        for(int num:colsum){
            if(num == 2){
                first.add(1);
                sec.add(1);
            }else if(num == 0){
                first.add(0);
                sec.add(0);
            }else {
                if(lower > 0) {
                    first.add(1);
                    lower--;
                }else{
                    first.add(0);
                    if(upper>0){
                        sec.add(1);
                        upper--;
                    }else{
                        sec.add(0);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(first);
        ans.add(sec);
        return ans;
    }
}
