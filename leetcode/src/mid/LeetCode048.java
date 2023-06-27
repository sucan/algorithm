package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:24
 * @Description:
 */
public class LeetCode048 {
    static boolean[][] vis = new boolean[21][21];
    public static void rotate(int[][] matrix) {
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                vis[i][j] = false;
            }
        }
        int n = matrix.length-1;
        for(int i = 0;i<=n;i++){
            for(int j =  0;j<=n;j++){
                if(!vis[i][j]){
                    solve(matrix,i,j,n);
                }
            }
        }
    }

    public static void solve(int[][] matrix,int i,int j,int n){
        int x = i,y = j;
        int value =  matrix[x][y];
        int tmpx = x;
        x = y;
        y = n - tmpx;
        while(!vis[x][y]){
            vis[x][y] = true;
            int tmp = matrix[x][y];
            matrix[x][y] = value;
            tmpx = x;
            x = y;
            y = n - tmpx;
            value = tmp;
        }
    }
}
