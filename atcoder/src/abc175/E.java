package abc175;

import java.util.Scanner;

public class E {
    private static final int MAX_N = 3010;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        long[][][] dp = new long[r+1][c+1][5];
        int[][] v = new int[r+1][c+1];
        for(int i = 0;i<k;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int value = scanner.nextInt();
            v[x][y] = value;
        }
        for(int i = 1;i<=r;i++){
            for(int j = 1;j<=c;j++){
                long Max = -1;
                for(int z = 0;z<=3;z++){
                    if(z == 0){
                        dp[i][j][z] = dp[i-1][j][4];
                        Max = max(Max,dp[i][j][z]);
                        continue;
                    }
                    dp[i][j][z] = max(dp[i][j-1][z],dp[i][j-1][z-1]+v[i][j]);
                    if(z == 1){
                        dp[i][j][z] = max(dp[i][j][z],dp[i][j][0]+v[i][j]);
                    }
                    Max = max(Max,dp[i][j][z]);
                }
                dp[i][j][4] = Max;
            }
        }
        System.out.println(dp[r][c][4]);
    }


    public static long max(long a,long b){
        if(a > b){
            return a;
        }
        return b;
    }
}
