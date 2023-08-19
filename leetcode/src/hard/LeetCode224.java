package hard;

import java.util.Stack;

/**
 * 基本计算器，分为操作符和操作数
 * 操作符：
 * 1. 左括号：直接入栈
 * 2. 右括号：操作符出栈并计算，直到匹配到左括号
 * 3. 其他：如果栈顶操作符优先级大于等于当前操作符，操作符出栈并计算，否则入栈
 * 操作数：
 * 1. 直接入栈
 * @Auther: kep
 * @Date: 2023/8/17 23:37
 * @Description:
 */
public class LeetCode224 {
    public int calculate(String s) {
        Stack<Integer> reverse = new Stack<>();
        reverse.add(1);
        Object[] next = getNext(0,s);
        int ans = 0;
        int sign = 1;
        while(next[1] != null){
            if(next[1] instanceof Integer){
                ans += sign*(Integer)next[1];
            }else{
                if("(".equals(next[1])){
                    reverse.add(sign);
                }else if(")".equals(next[1])){
                    reverse.pop();
                }else{
                    if("-".equals(next[1])){
                        sign = -reverse.peek();
                    }else{
                        sign = reverse.peek();
                    }
                }
            }
            next = getNext((Integer) next[0],s);
        }
        return ans;
    }


    private Object[] getNext(int start,String s){
        while(start < s.length() && s.charAt(start) == ' '){
            start++;
        }
        if(start == s.length()){
            return new Object[]{null,null};
        }
        int l = start;
        while(start <s.length() && s.charAt(start) >= '0' && s.charAt(start) <= '9'){
            start++;
        }
        if(start != l){
            return new Object[]{start,Integer.valueOf(s.substring(l,start))};
        }
        return new Object[]{start+1,s.substring(start,start+1)};
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode224().calculate(" 2-1 + 2 "));
    }
}
