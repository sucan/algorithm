package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/7/4 22:08
 * @Description:
 */
public class LeetCode098 {
    private static long pre = Long.MIN_VALUE;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<TreeNode> left = isValidNode(root.left);
        List<TreeNode> right = isValidNode(root.right);
        if(left == null || right == null){
            return false;
        }
        if(left.get(1) != null && left.get(1).val >= root.val){
            return false;
        }
        if(right.get(0) != null && right.get(0).val <= root.val){
            return false;
        }
        return true;
    }

    public boolean isValidBST_2(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST_2(root.left)){
            return false;
        }
        if(pre >= root.val){
            return false;
        }else{
            pre = root.val;
        }
        return isValidBST_2(root.right);
    }

    private List<TreeNode> isValidNode(TreeNode node){
        List<TreeNode> result = new ArrayList<>();
        if(node == null){
            result.add(null);
            result.add(null);
            return result;
        }
        List<TreeNode> left = isValidNode(node.left);
        List<TreeNode> right = isValidNode(node.right);
        if(left == null || right == null){
            return null;
        }
        if(left.get(1) != null && left.get(1).val >= node.val){
            return null;
        }
        if(right.get(0) != null && right.get(0).val <= node.val){
            return null;
        }
        result.add(0,left.get(0) == null?node:left.get(0));
        result.add(1,right.get(1) == null?node:right.get(1));
        return result;
    }

    public static void main(String[] args) {
        new LeetCode098().isValidBST_2(new TreeNode(0));
    }
}
