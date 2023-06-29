package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/30 00:28
 * @Description:
 */
public class LeetCode072 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<=word1.length();i++){
            for(int j = 0;j<=word2.length();j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for(int i = 0;i<=word1.length();i++){
            for(int j = 0;j<=word2.length();j++){
                if(i >0 && j > 0 && dp[i-1][j-1] != Integer.MAX_VALUE && word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }
                //替换
                if(i >0 && j > 0 && dp[i-1][j-1] != Integer.MAX_VALUE && word1.charAt(i-1) != word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                }
                //插入
                if(j > 0 && dp[i][j-1] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1] +1);
                }
                //删除
                if(i > 0 && dp[i-1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][j] +1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        new LeetCode072().minDistance("horse","ros");
    }
}
