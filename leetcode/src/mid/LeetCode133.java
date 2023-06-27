package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: kep
 * @Date: 2022/9/1 00:39
 * @Description:
 */
public class LeetCode133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node[] vis;

    public Node cloneGraph(Node node) {
        vis = new Node[101];
        return cloneNode(node);

    }

    private Node cloneNode(Node node){
        if(node == null){
            return null;
        }
        if(vis[node.val] != null){
            return vis[node.val];
        }
        Node cloneNode = new Node(node.val,new ArrayList<>());
        vis[node.val] = cloneNode;
        for(Node neighbor:node.neighbors){
            Node cloneNeighbor = cloneNode(neighbor);
            cloneNode.neighbors.add(cloneNeighbor);
        }
        return cloneNode;
    }
}
