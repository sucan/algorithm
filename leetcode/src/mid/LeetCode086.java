package mid;

/**
 * 也可以直接维护两个链表，一个小于x，一个大于等于x
 * @Auther: kep
 * @Date: 2023/6/23 20:45
 * @Description:
 */
public class LeetCode086 {


   public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }


    public ListNode partition(ListNode head, int x) {
        ListNode virHead  = new ListNode();
        virHead.next = head;
        ListNode preNode = virHead;
        ListNode currentNode = head;
        while(currentNode != null){
            if(currentNode.val >= x){
                break;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        if(currentNode != null){
            ListNode tmpPre = currentNode;
            ListNode tmpCurrent = currentNode.next;
            while(tmpCurrent != null){
                if(tmpCurrent.val < x){
                    ListNode tmpNext = tmpCurrent.next;
                    tmpPre.next = tmpNext;
                    preNode.next = tmpCurrent;
                    tmpCurrent.next = currentNode;
                    preNode = preNode.next;
                    tmpCurrent = tmpNext;
                }else{
                    tmpPre = tmpCurrent;
                    tmpCurrent = tmpCurrent.next;
                }
            }
        }
        return virHead.next;
    }
}
