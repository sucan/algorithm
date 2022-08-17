package mid;

/**
 * Created by enpingkuang on 2020/8/8 1:18 PM
 */
public class RemoveNthNodeFromEndofList {

    /**
     * Definition for singly-linked list.
     **/
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
        head = deleteNode(head,n);
        return reverse(head);
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public ListNode deleteNode(ListNode head,int n){
        ListNode tmp = head;
        ListNode pre = null;
        for(int i = 0;i<n-1;i++){
            pre = tmp;
            tmp = tmp.next;
        }
        if(pre == null){
            return tmp.next;
        }
        pre.next = tmp.next;
        return head;
    }
}
