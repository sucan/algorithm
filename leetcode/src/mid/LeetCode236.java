package mid;

import common.TreeBuilder;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kep
 * @Date: 2023/8/10 23:21
 * @Description:
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,Integer> nodeMap = new HashMap<>();
        TreeNode[][] parent = new TreeNode[100001][20];
        int[] depth = new int[100001];
        dfs(null,root,nodeMap,parent,depth);
        for(int i = 1;i<20;i++){
            for(int j = 0;j<nodeMap.size();j++){
                parent[j][i] = nodeMap.get(parent[j][i-1]) == null?null:parent[nodeMap.get(parent[j][i-1])][i-1];
            }
        }
        if(depth[nodeMap.get(p)] > depth[nodeMap.get(q)]){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while(depth[nodeMap.get(q)] > depth[nodeMap.get(p)]){
            q = parent[nodeMap.get(q)][0];
        }
        if(p == q){
            return q;
        }
        //
        for(int i = 19;i>=0;i--){
            if(parent[nodeMap.get(q)][i] != parent[nodeMap.get(p)][i]){
                q = parent[nodeMap.get(q)][i];
                p = parent[nodeMap.get(p)][i];
            }
        }
        return parent[nodeMap.get(q)][0];
    }

    private void dfs(TreeNode parent,TreeNode current,Map<TreeNode,Integer> nodeMap,TreeNode[][] pa,int[] depth){
        if(current == null){
            return;
        }
        nodeMap.put(current,nodeMap.size());
        int currentNum = nodeMap.get(current);
        depth[currentNum] = parent == null?0:depth[nodeMap.get(parent)] +1;
        pa[currentNum][0] = parent;
        dfs(current,current.getLeft(),nodeMap,pa,depth);
        dfs(current,current.getRight(),nodeMap,pa,depth);

    }

    public static void main(String[] args) {
        Integer[] value = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeBuilder.build(value);
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(8);
        new LeetCode236().lowestCommonAncestor(root,p,q);
    }
}
