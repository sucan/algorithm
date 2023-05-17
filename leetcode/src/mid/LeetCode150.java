package mid;

import java.util.Stack;

/**
 * @Auther: kep
 * @Date: 2023/5/17 22:27
 * @Description:
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token:tokens){
            if(token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/")){
                Integer a = Integer.valueOf(stack.pop());
                Integer b = Integer.valueOf(stack.pop());
                Integer c = null;
                if(token.equals("+")){
                    c = a+b;
                }else if(token.equals("-")){
                    c = b-a;
                }else if(token.equals("*")){
                    c = a*b;
                }else {
                    c = b/a;
                }
                stack.push(c+"");
            }else{
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
