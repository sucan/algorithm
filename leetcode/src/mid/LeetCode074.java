package mid;

/**
 * @Auther: kep
 * @Date: 2022/4/26 23:06
 * @Description:
 */
public class LeetCode074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = 0;
        int l = 0,r =  matrix.length-1;
        while(l <= r){
            int mid = (l + r)>>1;
            if(matrix[mid][0] > target){
                r = mid - 1 ;
            }else if(matrix[mid][0] == target){
                return true;
            }else{
                l = mid + 1;
            }
        }
        targetRow = r;
        if(targetRow == -1){
            return false;
        }
        l = 0;
        r = matrix[targetRow].length -1;
        while(l <= r){
            int mid = (l+r)>>1;
            if(matrix[targetRow][mid] > target){
                r = mid - 1;
            }else if(matrix[targetRow][mid] == target){
                return true;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
