package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/13 23:30
 * @Description:
 */
public class LeetCode025 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head,int k){
        ListNode tmpHead = new ListNode();
        tmpHead.next = head;
        ListNode preNode = tmpHead;
        ListNode currentNode = head;
        while(currentNode != null){
            ListNode nextNode = getNextNode(currentNode,k);
            ListNode preNextNode = getNextNode(currentNode,k-1);
            if(preNextNode == null){
                break;
            }
            preNode.next = reverseKNode(currentNode,k);
            currentNode.next = nextNode;
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        return tmpHead.next;
    }

    private ListNode getNextNode(ListNode head,int k){
        ListNode tmp = head;
        while(k-- > 0 && tmp != null){
            tmp = tmp.next;
        }
        return tmp;
    }

    public ListNode reverseKNode(ListNode head,int k){
        if(head == null){
            return null;
        }
        ListNode currentNode = head;
        if(k == 1 || currentNode.next == null){
            currentNode.next = null;
            return currentNode;
        }
        ListNode nextNode = currentNode.next;
        ListNode tmp = reverseKNode(currentNode.next,k-1);
        nextNode.next = currentNode;
        return tmp;
    }
}
