package mid;

/**
 * @Auther: kep
 * @Date: 2022/7/1 23:03
 * @Description:
 */
public class LeetCode092 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPre = null;
        ListNode rightNext  = null;
        ListNode leftNode = head;
        ListNode rightNode = head;
        for(int i = 1;i<right;i++){
            if(i < left){
                leftPre = leftNode;
                leftNode = leftNode.next;
            }
            rightNode = rightNode.next;
            rightNext = rightNode.next;
        }
        reverse(leftNode,rightNode);
        leftNode.next = rightNext;
        if(leftPre != null){
            leftPre.next = rightNode;
            return head;
        }else {
            return rightNode;
        }
    }

    public void reverse(ListNode leftNode,ListNode rightNode){
        ListNode preNode = null;
        ListNode tmpNode = leftNode;
        while(preNode != rightNode){
            ListNode next = tmpNode.next;
            if(preNode != null){
                tmpNode.next = preNode;
            }
            preNode = tmpNode;
            tmpNode = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        new LeetCode092().reverseBetween(head,1,2);
    }
}
