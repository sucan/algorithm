package mid;

/**
 * @Auther: kep
 * @Date: 2022/8/16 22:16
 * @Description:
 */
public class LeetCode114 {
    private TreeNode currentIndex;
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

    public void flatten(TreeNode root) {
        currentIndex = root;
        convertTree2List(root);
    }

    private void convertTree2List(TreeNode current){
        if(current == null){
            return;
        }
        currentIndex = current;
        TreeNode tmp = current.right;
        current.right = current.left;
        current.left = null;
        convertTree2List(current.right);
        currentIndex.right = tmp;
        convertTree2List(tmp);
    }
}
