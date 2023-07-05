package hard;

/**
 * @Auther: kep
 * @Date: 2023/7/5 23:45
 * @Description:
 */
public class LeetCode124 {
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
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxEdge(root);
        return ans;
    }

    public int maxEdge(TreeNode root){
        if(root == null){
            return 0;
        }
        int maxSum = root.val;
        int maxLeft = maxEdge(root.left);
        int maxRight = maxEdge(root.right);
        if(maxLeft > 0){
            maxSum += maxLeft;
        }
        if(maxRight > 0){
            maxSum += maxRight;
        }
        ans = Math.max(ans,maxSum);
        return Math.max(root.val,root.val + Math.max(maxLeft,maxRight));
    }
}
