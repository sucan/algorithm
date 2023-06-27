package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:21
 * @Description:
 */
public class LeetCode054 {
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[] dirNum = new int[4];
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int length = matrix[0].length;
        int width = matrix.length;
        int count = length * width;
        int x=0,y=0;
        dirNum[0] = dirNum[2] = length - 1;
        dirNum[1] = width -1;
        dirNum[3] = width -2;
        while(count > 0){
            result.add(matrix[x][y]);
            count--;
            if (count <= 0){
                break;
            }
            for(int j = 0;j<4;j++){
                if(dirNum[j] < 0 || count <= 0){
                    break;
                }
                for(int z =0;z<dirNum[j];z++) {
                    x += dir[j][0];
                    y += dir[j][1];
                    result.add(matrix[x][y]);
                    count--;
                    if (count <= 0){
                        break;
                    }
                }
                dirNum[j]-=2;
            }
            x += dir[0][0];
            y += dir[0][1];
        }
        return result;
    }
}
