package datastructure.tree;

/**
 * 二叉树
 * Created by enpingkuang on 2020/8/2 1:11 AM
 */
public class BinaryTree {

    private static Node head = new Node();

    public static Node find(Node node,int value){
        if(node == null){
            return null;
        }
        if(node.getValue() == value){
            return node;
        }
        if(node.getValue() > value){
            return  find(node.left,value);
        }else {
            return find(node.right,value);
        }
    }

    public static Node insert(Node node,int value){
        if(node == null){
            node = new Node();
            node.setValue(value);
            return node;
        }
        if(node.getValue() > value){
            node.setLeft(insert(node.left,value));
            return node;
        }else {
            node.setRight(insert(node.right,value));
            return node;
        }
    }

    public static Node delete(Node node,int value){
        if(node == null || node.getValue() == value){
            return null;
        }
        if(node.getValue() > value){
            node.setLeft(insert(node.left,value));
            return node;
        }else {
            node.setRight(insert(node.right,value));
            return node;
        }
    }

    public static void main(String[] args){
        for(int i = 10;i>=1;i--){
            insert(head,i+1);
            Node node = find(head,i+1);
            System.out.println(node.value);
        }
    }


    @Data
    static class Node {
        private int  value;
        private Node left;
        private Node right;
    }
}
