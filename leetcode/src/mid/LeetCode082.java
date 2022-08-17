package mid;

/**
 * @Auther: kep
 * @Date: 2022/4/28 21:59
 * @Description:
 */
public class LeetCode082 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        ListNode pre = null;
        while(tmp != null){
            ListNode next = tmp.next;
            if(next != null && tmp.val == next.val){
                while(next != null && next.next != null && next.val == next.next.val)next = next.next;
                if(pre == null){
                    head = next.next;
                    tmp = next.next;
                }else{
                    pre.next = next.next;
                    tmp = next.next;
                }
            }else{
                pre = tmp;
                tmp = next;
            }
        }
        return head;
    }
}
