package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/11 23:03
 * @Description:
 */
public class LeetCode037 {

    private boolean stop = false;
    public void solveSudoku(char[][] board) {
         int[] row = new int[board.length];
         int[] col = new int[board.length];
         int[][] block = new int[(board.length+2)/3][(board.length+2)/3];
         List<int[]> points = new ArrayList<>();
         for(int i = 0;i<board.length;i++){
             for(int j = 0;j<board[i].length;j++){
                 if(board[i][j] >='0' && board[i][j] <= '9'){
                     int number = (1<<(board[i][j] - '0'));
                     row[i] |= number;
                     col[j] |= number;
                     block[i/3][j/3] |= number;
                 }else{
                     int[]  point = {i,j};
                     points.add(point);
                 }
             }
         }
         stop = false;
         dfs(0,points,board,block,row,col);
    }

    private void dfs(int pointIndex,List<int[]> points,char[][] board,int[][] block,int[] row,int[] col){
        if(pointIndex == points.size()){
            stop = true;
            return;
        }
        int i = points.get(pointIndex)[0];
        int j = points.get(pointIndex)[1];
        for(int number = 1;number<=9;number++){
            if((block[i/3][j/3] & (1<<number)) == 0
                    && (row[i] & (1<<number)) == 0
                    &&(col[j] & (1<<number)) == 0){

                int tmpBlock = block[i/3][j/3];
                int tmpRow = row[i];
                int tmpCol = col[j];

                board[i][j] = (char)(number +'0');
                block[i/3][j/3] |= (1<<number);
                row[i] |= (1<<number);
                col[j] |= (1<<number);

                dfs(pointIndex+1,points,board,block,row,col);
                if(stop){
                    break;
                }
                board[i][j] = '.';
                block[i/3][j/3] = tmpBlock;
                row[i] = tmpRow;
                col[j] = tmpCol;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new LeetCode037().solveSudoku(board);
    }
}
