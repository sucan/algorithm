package mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kep
 * @Date: 2022/11/17 00:26
 * @Description:
 */
public class LeetCode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Map<Node,Node> copyMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node copyNode = copyMap.get(head);
        if(copyNode != null || head == null){
            return copyNode;
        }
        copyNode = new Node(head.val);
        copyMap.put(head,copyNode);
        copyNode.next = copyRandomList(head.next);
        copyNode.random = copyRandomList(head.random);
        return copyNode;
    }
}
