/**
 * @Auther: kep
 * @Date: 2022/8/14 16:00
 * @Description:
 */
public class LeetCode105 {
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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0,0,inorder.length-1,preorder,inorder);
    }

    private TreeNode buildTree(int preIndex,int inLeftIndex,int inRightIndex,int[] preorder, int[] inorder){
        if(inLeftIndex == inRightIndex){
            return new TreeNode(inorder[inLeftIndex]);
        }
        if(inLeftIndex > inRightIndex){
            return null;
        }
        if(preIndex >= preorder.length){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]);
        int mid = 0;
        for(int i = inLeftIndex;i<=inRightIndex;i++){
            if(inorder[i] == preorder[preIndex]){
                mid = i;
                break;
            }
        }
        node.left = buildTree(preIndex + 1,inLeftIndex,mid-1,preorder,inorder);
        node.right = buildTree(preIndex + (mid-inLeftIndex+1),mid+1,inRightIndex,preorder,inorder);
        return node;
    }
}
