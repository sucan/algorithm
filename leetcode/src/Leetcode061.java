/**
 * @Auther: kep
 * @Date: 2022/4/23 16:23
 * @Description:
 */
public class Leetcode061 {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int n = 1;
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            n++;
        }
        tmp.next = head;
        k = k%n;
        int step = n-k-1;
        while(step-- > 0){
            head = head.next;
        }
        tmp = head.next;
        head.next = null;
        return tmp;

    }
}
