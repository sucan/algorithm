package hard;

/**
 * dp[i][j] node i 的第2的j次方节点
 * @Auther: kep
 * @Date: 2023/6/12 22:12
 * @Description:
 */
public class Leetcode1483 {
    private int[] parent;
    private int[][] dp;

    public Leetcode1483(int n, int[] parent) {
        dp = new int[n][17];
        this.parent = parent;
        for(int i = 0;i<n;i++){
            dp[i][0] = parent[i];
        }
        for(int j = 1;j<17;j++){
            for(int i = 0;i<n;i++){
                dp[i][j] = dp[i][j-1] == -1?-1:dp[dp[i][j-1]][j-1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int index = 0;
        while(k !=0 && node != -1){
            if((k & 1) == 1){
                node = dp[node][index];
            }
            k = k>>1;
            index++;
        }
        return node;
    }
}
