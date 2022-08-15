import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2022/8/15 22:14
 * @Description:
 */
public class LeetCode113 {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        dfs(root,targetSum,0,ans,tmp);
        return ans;
    }

    private void dfs(TreeNode currentNode, int targetSum, int tmpSum, List<List<Integer>> ans, LinkedList<Integer> tmp){
        if(currentNode == null){
            return;
        }
        if(currentNode.left == null && currentNode.right == null && targetSum == tmpSum + currentNode.val){
            List<Integer> subAns = new ArrayList<>(tmp);
            subAns.add(currentNode.val);
            ans.add(subAns);
            return;
        }
        tmp.addLast(currentNode.val);
        dfs(currentNode.left,targetSum,tmpSum + currentNode.val,ans,tmp );
        dfs(currentNode.right,targetSum,tmpSum + currentNode.val,ans,tmp );
        tmp.removeLast();
    }

    public static void main(String[] args) {
        Integer[] values = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        new LeetCode113().pathSum(buildTree(values,1),22);
    }

    private static TreeNode buildTree(Integer[] values,int index){
        if(values.length < index || values[index-1] == null){
            return null;
        }
        TreeNode root = new TreeNode(values[index-1]);
        root.left = buildTree(values,index * 2);
        root.right = buildTree(values,index * 2 + 1);
        return root;
    }
}
