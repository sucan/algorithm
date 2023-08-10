import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: kep
 * @Date: 2023/8/9 22:17
 * @Description:
 */
public class Test {
    public int[][] foundMonotoneStack (int[] nums) {
        // write code here
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        int[][] ans = new int[nums.length][2];
        Stack<Integer> q = new Stack();
        for(int i = 0;i<nums.length;i++){
            if(q.isEmpty()){
                q.add(i);
                continue;
            }
            while(nums[q.peek()] > nums[i]){
                int index = q.pop();
                right[index] = i;
                if(q.isEmpty()){
                    break;
                }
            }
            q.add(i);
        }
        while(!q.isEmpty()){
            int index = q.pop();
            right[index] = -1;
        }
        //
        for(int i = nums.length-1;i>=0;i--){
            if(q.isEmpty()){
                q.add(i);
                continue;
            }
            while(nums[q.peek()] > nums[i]){
                int index = q.pop();
                left[index] = i;
                if(q.isEmpty()){
                    break;
                }
            }
            q.add(i);
        }
        while(!q.isEmpty()){
            int index = q.pop();
            left[index] = -1;
        }
        for(int i = 0;i<nums.length;i++){
            ans[i][0] = left[i];
            ans[i][1] = right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {3,4,1,5,6,2,7};
        new Test().foundMonotoneStack(x);
    }
}
