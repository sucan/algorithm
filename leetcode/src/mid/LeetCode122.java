package mid;

import java.util.Stack;

/**
 * @Auther: kep
 * @Date: 2022/8/17 22:57
 * @Description:
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        Integer tmp = null;
        for(int i = 0;i<prices.length;i++){
            if(tmp == null){
                tmp = prices[i];
            }else{
                if(prices[i] > tmp){
                    ans += prices[i] - tmp;
                    tmp = prices[i];
                }else{
                    tmp = prices[i];
                }
            }
        }
        return ans;
    }
}
