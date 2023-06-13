package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/13 22:00
 * @Description:
 */
public class LeetCode023 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int step = 1;
        int times = 0;
        int length = lists.length;
        while(length != 1){
            times++;
            length = length/2 + length %2;
        }
        for(int i = 0;i<times;i++){
            int flag = 0;
            for(int j = 0;j<lists.length;j+=step){
                if(flag == 1){
                    lists[j-step] =  mergeTwoList(lists[j-step],lists[j]);
                }
                flag = (flag +1)%2;
            }
            step*=2;
        }
        return lists[0];
    }

    private ListNode mergeTwoList(ListNode left,ListNode right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        ListNode head = new ListNode();
        ListNode tmp = head;
        ListNode tmpLeft = left;
        ListNode tmpRight = right;
        while(tmpLeft != null || tmpRight != null){
            if(tmpLeft == null){
                tmp.next = tmpRight;
                break;
            }
            if(tmpRight == null){
                tmp.next = tmpLeft;
                break;
            }
            if(tmpLeft.val < tmpRight.val){
                tmp.next = tmpLeft;
                tmpLeft = tmpLeft.next;
            }else{
                tmp.next = tmpRight;
                tmpRight = tmpRight.next;
            }
            tmp = tmp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
