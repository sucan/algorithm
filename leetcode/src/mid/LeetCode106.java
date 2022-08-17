package mid;

/**
 * @Auther: kep
 * @Date: 2022/8/14 16:21
 * @Description:
 */
public class LeetCode106 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(0,inorder.length-1,0,postorder.length -1,inorder,postorder);
    }

    private TreeNode buildTree(int il,int ir,int pl,int pr,int[] inorder, int[] postorder){
        if(il > ir || pl > pr || il < 0 || pl < 0){
            return null;
        }
        if(il == ir){
            return new TreeNode(inorder[il]);
        }
        if(pl == pr){
            return new TreeNode(postorder[pl]);
        }
        TreeNode node = new TreeNode(postorder[pr]);
        int imid = 0;
        for(int i = il;i<=ir;i++){
            if(inorder[i] == postorder[pl]){
                imid = i;
                break;
            }
        }
        node.right = buildTree(imid+1,ir,pr-(ir-imid),pr-1,inorder,postorder);
        node.left = buildTree(il,imid-1,pl,pr-(ir-imid)-1,inorder,postorder);
        return node;
    }
}
