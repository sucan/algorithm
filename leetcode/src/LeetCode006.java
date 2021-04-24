import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode006 {
    /**
     * 计算出每个字符的坐标即可
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        boolean flag = true;
        List<Node> result = new ArrayList<>();
        int x = 1;
        int y = 1;
        result.add(new Node(x,y,s.charAt(0)));
        for(int i = 1;i<s.length();i++){
            if(flag){
                y++;
                result.add(new Node(x,y,s.charAt(i)));
                if (y == numRows){
                    flag = false;
                }
            }else{
                x++;
                y--;
                result.add(new Node(x,y,s.charAt(i)));
                if(y == 1){
                    flag = true;
                }
            }
        }
        Collections.sort(result);
        StringBuilder stringBuilder = new StringBuilder();
        for(Node node:result){
            stringBuilder.append(node.value);
        }
        return stringBuilder.toString();
    }

    static class Node implements Comparable<Node>{
        private int xIndex;
        private int yIndex;
        private char value;

        Node(int x,int y,char value){
            this.xIndex = x;
            this.yIndex = y;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            if(yIndex != o.yIndex){
                return -o.yIndex + yIndex;
            }else{
                return -o.xIndex + xIndex;
            }
        }
    }

    public static void main(String[] args) {
        System.out.printf(convert("PAYPALISHIRING",3));
    }
}
