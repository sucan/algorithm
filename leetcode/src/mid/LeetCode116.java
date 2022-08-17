package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/8/16 22:50
 * @Description:
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        List<Node> currentNode = new ArrayList<>();
        currentNode.add(root);
        while(!currentNode.isEmpty()){
            List<Node> tmp = new ArrayList<>();
            Node pre = null;
            for(Node node:currentNode){
                if(node == null){
                    continue;
                }
                if(pre != null){
                    pre.next = node;
                }
                pre= node;
                if(node.left != null) {
                    tmp.add(node.left);
                }
                if(node.right != null) {
                    tmp.add(node.right);
                }
            }
            currentNode = tmp;
        }
        return root;
    }
}
