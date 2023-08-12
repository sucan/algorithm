package mid;

import java.util.Stack;

/**
 * @Auther: kep
 * @Date: 2023/8/11 20:01
 * @Description:
 */
public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        int[] nums = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int ans = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] == '0'){
                    nums[j] = 0;
                }else{
                    nums[j]++;
                }
            }
            ans = Math.max(ans,solve(nums,left,right));
        }
        return ans;
    }

    private int solve(int[] nums,int[] left,int[] right){
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            left[i] = right[i] = i;
        }
        fullLeftIndexNum(nums,left);
        fullRightIndexNum(nums,right);
        for(int i = 0;i<nums.length;i++){
            if(right[i] - left[i] + 1 >= nums[i]){
                ans = Math.max(ans,nums[i] * nums[i]);
            }
        }
        return ans;
    }

    private void fullLeftIndexNum(int[] nums,int[] left){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                left[i] = stack.peek() +1;
            }else{
                left[i] = 0;
            }
            stack.push(i);
        }
    }

    private void fullRightIndexNum(int[] nums,int[] right){
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                right[i] = stack.peek() - 1;
            }else{
                right[i] = nums.length - 1;
            }
            stack.push(i);
        }
    }
}
