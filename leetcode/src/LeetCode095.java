import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/7/2 17:26
 * @Description:
 */
public class LeetCode095 {

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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> leftSubTrees = generateTrees(start,i-1);
            List<TreeNode> rightSubTrees = generateTrees(i+1,end);
            for(TreeNode left:leftSubTrees){
                for(TreeNode right:rightSubTrees){
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    result.add(head);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new LeetCode095().generateTrees(3);
    }
}
