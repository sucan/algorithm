/**
 * 最开始读错题了，以为是给定初始盘面，求数独是否有解，不由得产生了这尼玛是道mid？的想法
 * 后面才发现只是求给出的盘面是否有效即可，难度一下子下降了几个数量级
 *
 * 按照数独的定义将其分为 行、列、宫，遍历一遍数独，然后分别判断行、列、宫中是否有重复数字即可
 * 判重可以直接用位运算提速
 *
 * @Auther: kep
 * @Date: 2021/8/30 22:27
 * @Description:
 */
public class LeetCode036 {
    public static boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] square = new int[9];
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int squareIndex = 3 * (i/3) + j/3;
                if(!checkBox(row[i],board[i][j]-'0') ||
                !checkBox(col[j],board[i][j]-'0') ||
                !checkBox(square[squareIndex],board[i][j]-'0')){
                    return false;
                }
                row[i] |= 1<<(board[i][j]-'0');
                col[j] |= 1<<(board[i][j]-'0');
                square[squareIndex] |= 1<<(board[i][j]-'0');
            }
        }
        return true;
    }

    private static boolean checkBox(int x,int y){
        return (x>>y & 1) == 0;
    }

    public static void main(String[] args) {
        char[][] x = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        isValidSudoku(x);
    }
}
