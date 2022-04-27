/**
 * @Auther: kep
 * @Date: 2022/4/27 22:44
 * @Description:
 */
public class LeetCode079 {
    public int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] vis;
    public char[][] map;

    public boolean exist(char[][] board, String word) {
        map = board;
        vis = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    vis[i][j] = 1;
                    boolean result= dfs(i,j,word,1);
                    if(result){
                        return result;
                    }
                    vis[i][j] = 0;
                }
            }
        }
        return false;
    }

    boolean dfs(int x,int y,String word,int step){
        if(step == word.length()){
            return true;
        }
        for(int i = 0;i<4;i++){
            int tmpX = x + dir[i][0];
            int tmpY = y + dir[i][1];
            if(tmpX >= map.length || tmpX < 0)continue;
            if(tmpY >= map[0].length || tmpY < 0)continue;
            if(vis[tmpX][tmpY] == 0 && word.charAt(step) == map[tmpX][tmpY]){
                vis[tmpX][tmpY] = 1;
                boolean result = dfs(tmpX,tmpY,word,step+1);
                if(result){
                    return true;
                }
                vis[tmpX][tmpY] = 0;
            }
        }
        return false;
    }
}
