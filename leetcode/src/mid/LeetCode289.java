package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/5 20:59
 * @Description:
 */
public class LeetCode289 {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};

    private int getLiveCount(int[][] board,int x,int y){
        int ans = 0;
        for(int i = 0;i<8;i++){
            int tmpX = x + dir[i][0];
            int tmpY = y + dir[i][1];
            if(tmpX < 0 || tmpX >= board.length){
                continue;
            }
            if(tmpY <0 || tmpY >= board[0].length){
                continue;
            }
            if(board[tmpX][tmpY] == 1){
                ans++;
            }
        }
        return ans;
    }


    public void gameOfLife(int[][] board) {
        int[][] map = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                int liveCount = getLiveCount(board,i,j);
                if(board[i][j] == 1){
                    if(liveCount < 2 ||  liveCount > 3){
                        map[i][j] = 0;
                    }else{
                        map[i][j] = 1;
                    }
                }else{
                    if(liveCount == 3){
                        map[i][j] = 1;
                    }else{
                        map[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = map[i][j];
            }
        }
    }
}
