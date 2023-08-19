package mid;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Auther: kep
 * @Date: 2023/8/17 23:02
 * @Description:
 */
public class LeetCode173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class BSTIterator {
        private Stack<TreeNode> stack;
        private TreeNode current;
        public BSTIterator(TreeNode root) {
            current = root;
            stack = new Stack<>();
        }

        public int next() {
            while(current != null){
                stack.push(current);
                if(current.left == null){
                    break;
                }
                current = current.left;
            }
            TreeNode tmp = stack.pop();
            int ans = tmp.val;
            current = tmp.right;
            return ans;
        }

        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }
    }
}
