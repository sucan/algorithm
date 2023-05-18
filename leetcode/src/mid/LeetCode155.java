package mid;

import java.util.LinkedList;

/**
 * @Auther: kep
 * @Date: 2023/5/18 22:24
 * @Description:
 */
public class LeetCode155 {

    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int val) {
        stack.addFirst(val);
        if(minStack.isEmpty() || val < minStack.getFirst()){
            minStack.addFirst(val);
        }else{
            minStack.addFirst(minStack.getFirst());
        }
    }

    public void pop() {
        stack.removeFirst();
        minStack.removeFirst();
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }
}
