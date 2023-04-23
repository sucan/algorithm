package mid;

/**
 * @Auther: kep
 * @Date: 2023/4/23 23:09
 * @Description:
 */
public class LeetCode147 {

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
    //4 2 1 3
    public ListNode insertionSortList(ListNode head) {
        ListNode emptyHead = new ListNode();
        ListNode originListIndex = head;
        while(originListIndex != null){
            ListNode newListIndex = emptyHead;
            while(newListIndex.next != null){
                if(originListIndex.val < newListIndex.next.val){
                    break;
                }
                newListIndex = newListIndex.next;
            }
            ListNode tmpNode = originListIndex.next;
            originListIndex.next = newListIndex.next;
            newListIndex.next = originListIndex;
            originListIndex = tmpNode;

        }
        return emptyHead.next;
    }

}
