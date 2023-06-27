package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:08
 * @Description:
 */
public class LeetCode019 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = revolve(head);
        head = deleteKNode(head,n);
        return revolve(head);
    }

    public ListNode deleteKNode(ListNode head, int k) {
        int length = 1;
        ListNode current = head;
        ListNode pre = null;
        while(current != null){
            if(k == length){
                if(pre == null){
                    ListNode tmp =  current.next;
                    current.next = null;
                    return tmp;
                }else{
                    pre.next = current.next;
                }
            }
            pre = current;
            current = current.next;
            length++;
        }
        return head;
    }

    public ListNode revolve(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode nextNode = head.next;
        if(nextNode == null){
            return head;
        }
        head.next = null;
        ListNode tmpHead = revolve(nextNode);
        nextNode.next = head;
        return tmpHead;
    }
}
