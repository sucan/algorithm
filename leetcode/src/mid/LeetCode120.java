package mid;

import java.util.List;

/**
 * dp + 数组优化
 * @Auther: kep
 * @Date: 2022/8/17 22:36
 * @Description:
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(int i = 0;i<triangle.size();i++){
            dp[i] = Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<triangle.size();i++){
            for(int j = triangle.get(i).size() - 1;j>=0;j--){
                if(i==0 && j== 0){
                    dp[j] = triangle.get(i).get(j);
                    continue;
                }
                if(j != 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }else{
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
            }
        }
        for(int i = 0;i<triangle.size();i++){
            ans = Math.min(ans,dp[i]);
        }
        return ans;
    }
}
