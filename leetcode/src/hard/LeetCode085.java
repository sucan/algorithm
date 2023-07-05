package hard;

import java.util.Stack;

/**
 * @Auther: kep
 * @Date: 2023/7/1 15:51
 * @Description:
 */
public class LeetCode085 {

    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int col[] = new int[matrix[0].length+1];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(i == 0){
                    col[j] = matrix[i][j] - '0';
                }else{
                    if(matrix[i][j] - '0' == 0){
                        col[j] = 0;
                    }else{
                        col[j]++;
                    }
                }
            }
            ans = Math.max(ans,largestRectangleArea(col));
        }

        return ans;
    }

    private int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for(int i = 0;i<heights.length;i++){
            if(stack.size() == 0){
                stack.push(i);
                left[i] = 0;
            }else{
                Integer peek = stack.peek();
                int num = 0;
                while(!stack.isEmpty() && heights[peek] >= heights[i]){
                    num += left[peek]+1;
                    stack.pop();
                    if(!stack.isEmpty()) {
                        peek = stack.peek();
                    }
                }
                left[i] = num;
                stack.push(i);
            }
        }
        stack.clear();
        for(int i = heights.length-1;i>=0;i--){
            if(stack.size() == 0){
                stack.push(i);
                right[i] = 0;
            }else{
                Integer peek = stack.peek();
                int num = 0;
                while(!stack.isEmpty() && heights[peek] >= heights[i]){
                    num += right[peek]+1;
                    stack.pop();
                    if(!stack.isEmpty()) {
                        peek = stack.peek();
                    }
                }
                right[i] = num;
                stack.push(i);
            }
        }
        for(int i = 0;i<heights.length;i++){
            ans = Math.max((right[i] + left[i]+1) * heights[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(new LeetCode085().maximalRectangle(matrix));
    }
}
