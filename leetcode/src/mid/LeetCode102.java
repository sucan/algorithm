package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: kep
 * @Date: 2022/8/14 15:36
 * @Description:
 */
public class LeetCode102 {
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

    class Node {
        public Node(int level, TreeNode node){
            this.level = level;
            this.treeNode = node;
        }
        int level = 0;
        TreeNode treeNode;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,root));
        List<Integer> tmp = new ArrayList<>();
        int level = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.treeNode == null){
                continue;
            }
            if(node.level != level){
                ans.add(tmp);
                tmp = new ArrayList<>();
                level = node.level;
            }
            tmp.add(node.treeNode.val);
            if(node.treeNode.left != null){
                queue.add(new Node(node.level +1,node.treeNode.left));
            }
            if(node.treeNode.right != null){
                queue.add(new Node(node.level +1,node.treeNode.right));
            }
        }
        if(tmp.size() > 0){
            ans.add(tmp);
        }
        return ans;
    }
}
