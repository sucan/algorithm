package easy;

/**
 * @Auther: kep
 * @Date: 2023/5/18 22:36
 * @Description:
 */
public class LeetCode160 {


     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        if(pa == null || pb == null){
            return null;
        }
        while(pa != pb){
            if(pa.next == null && pb.next == null){
                return null;
            }
            pa = pa.next == null?headB:pa.next;
            pb = pb.next == null?headA:pb.next;
        }
        return pa;
    }
}
