package mid;

/**
 * Created by enpingkuang on 2020/8/8 1:19 PM
 */
public class ReverseNodesinkGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        int index = 1;
        ListNode currentNode = head;
        ListNode pre = null;
        ListNode ans = null;
        while(currentNode != null){
            ListNode next = currentNode.next;
            if(index % k == 0){
                reverse(head,k);
                if(pre != null){
                    pre.next = currentNode;
                }
                if(ans == null){
                    ans = currentNode;
                }
                pre = head;
                head.next = next;
                head = next;
            }
            currentNode = next;
            index++;
        }
        return ans == null?head:ans;
    }


    public void reverse(ListNode head,int k){
        ListNode pre = null;
        ListNode now = head;
        while(now != null && k-- > 0){
            ListNode tmp = now.next;
            now.next = pre;
            pre = now;
            now = tmp;
        }
    }
}
