package hard;

import java.util.Stack;

/**
 * @Auther: kep
 * @Date: 2023/7/1 00:10
 * @Description:
 */
public class LeetCode084 {
    public int largestRectangleArea(int[] heights) {
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
}
