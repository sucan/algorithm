package mid;

/**
 * 简单dfs
 * @Auther: kep
 * @Date: 2022/8/31 00:25
 * @Description:
 */
public class LeetCode130 {
    private boolean[][] vis;
    private int[][] dir  = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        vis = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(i == 0 || i == board.length - 1 || j == 0 || j == board[i].length -1){
                    if(board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(!vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board,int x,int y){
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0){
            return;
        }
        if(board[x][y] != 'O' || vis[x][y]){
            return;
        }
        vis[x][y] = true;
        for(int i = 0;i<4;i++){
            int tmpX = x + dir[i][0];
            int tmpY = y + dir[i][1];
            dfs(board,tmpX,tmpY);
        }
    }
}
