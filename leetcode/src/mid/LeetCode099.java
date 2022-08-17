package mid;

import java.util.List;

/**
 * 中序遍历，寻找不符合条件的节点
 * @Auther: kep
 * @Date: 2022/8/11 23:04
 * @Description:
 */
public class LeetCode099 {

    private TreeNode pre;

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


    public void recoverTree(TreeNode root) {
        TreeNode[] ans = new TreeNode[2];
        pre = null;
        solve(root,ans);
        int tmp = ans[0].val;
        ans[0].val = ans[1].val;
        ans[1].val = tmp;
    }

    private void solve(TreeNode current, TreeNode[] ans){
        if(current == null){
            return;
        }
        solve(current.left,ans);
        if(pre != null && current.val < pre.val){
            ans[1] = current;
            if(ans[0] == null){
                ans[0] = pre;
            }
        }
        pre = current;
        solve(current.right,ans);
    }

    public static void main(String[] args) {

    }
}
