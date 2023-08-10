package common;

import common.TreeNode;

import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/8/11 00:08
 * @Description:
 */
public class TreeBuilder {
    public static TreeNode build(Integer[] value){
        return buildTree(1,value);
    }

    private static TreeNode buildTree(int index,Integer[] value){
        if(value.length < index || value[index-1] == null){
            return null;
        }
        TreeNode current = new TreeNode(value[index-1]);
        current.setLeft(buildTree(index<<1,value));
        current.setRight(buildTree(index<<1|1,value));
        return current;
    }
}
