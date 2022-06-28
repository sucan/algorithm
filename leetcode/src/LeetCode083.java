/**
 * @Auther: kep
 * @Date: 2022/4/30 16:49
 * @Description:
 */
public class LeetCode083 {
    public static class ListNode {
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
    public ListNode partition(ListNode head, int x) {
        ListNode gatherHead = null;
        ListNode gatherIndex = null;
        ListNode lessHead = null;
        ListNode lessIndex = null;
        while(head != null){
            if(head.val < x){
                if(lessHead == null){
                    lessHead = lessIndex = head;
                }else{
                    lessIndex.next = head;
                    lessIndex = head;
                }
            }else{
                if(gatherHead == null){
                    gatherHead = gatherIndex = head;
                }else{
                    gatherIndex.next = head;
                    gatherIndex = head;
                }
            }
            head = head.next;
        }
        if(lessIndex != null) {
            lessIndex.next = gatherHead;
        }else{
            lessHead = gatherHead;
        }
        if(gatherIndex != null){
            gatherIndex.next = null;
        }
        return lessHead;
    }

    //[1,4,3,2,5,2]
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next= new ListNode(2);
        new LeetCode083().partition(head,3);
    }
}
