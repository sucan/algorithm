package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/6 17:21
 * @Description:
 */
public class LeetCode230 {
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

    private int index = 0;
    private int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        ans = 0;
        scan(root,k);
        return ans;
    }

    public void scan(TreeNode root,int k){
        if(root == null){
            return;
        }
        scan(root.left,k);
        index++;
        if(index == k){
            ans = root.val;
        }
        scan(root.right,k);
    }
}
