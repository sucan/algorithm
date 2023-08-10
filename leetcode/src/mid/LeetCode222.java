package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/10 22:34
 * @Description:
 */
public class LeetCode222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


    public int countNodes(TreeNode root) {
        TreeNode tmp = root;
        int level = 0;
        while(tmp != null){
            level++;
            tmp = tmp.left;
        }
        level--;
        if(level == -1){
            return 0;
        }
        int ans = (1<<level)-1;
        int left = 1<<level,right = (1<<(level+1)) - 1;
        while(left <= right){
            int mid = (left + right)>>1;
            if(exist(mid,level-1,root)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        ans += (right - (1<<level) + 1);
        return ans;
    }

    private boolean exist(int number,int depth,TreeNode root){
        if(root == null){
            return false;
        }
        if(depth == -1){
            return true;
        }
        if((number & (1<<depth)) == 0){
            return exist(number,depth-1,root.left);
        }else{
            return exist(number,depth-1,root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode();
        treeNode.left.left = new TreeNode();
        treeNode.left.right = new TreeNode();

        treeNode.right = new TreeNode();
        treeNode.right.left = new TreeNode();

        new LeetCode222().countNodes(treeNode);
    }
}
