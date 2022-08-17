package mid;

/**
 * @Auther: kep
 * @Date: 2022/8/17 23:11
 * @Description:
 */
public class LeetCode129 {
    private int ans = 0;
    public class TreeNode {
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

    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode node,int subSum){
        if(node == null){
            return;
        }
        subSum += node.val;
        if(node.left == null && node.right == null){
            ans += subSum;
            return;
        }
        if(node.left != null) {
            dfs(node.left, subSum * 10);
        }
        if(node.right != null) {
            dfs(node.right, subSum * 10);
        }
    }
}
