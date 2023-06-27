package mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 0 -> 1 -> 2 -> 3 -> 4 -> 5
 *
 * 0 1 2
 * | | |
 * 5 4 3
 *
 *
 *
 * @Auther: kep
 * @Date: 2023/2/13 21:57
 * @Description:
 */
public class LeetCode143 {


     public class ListNode {
         int val;
          ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public void reorderList(ListNode head) {
        List<ListNode> arrayList = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            arrayList.add(tmp);
            tmp = tmp.next;
        }
        int j = arrayList.size() - 1;
        for(int i = 0;i<=j;i++,j--){
            ListNode l1 =  arrayList.get(i);
            ListNode l2 = arrayList.get(j);
            if(l1 == l2){
                l1.next = null;
                continue;
            }
            ListNode next = l1.next;
            l1.next = l2;
            l2.next = null;
            if(next != l2){
                l2.next = next;
            }
        }
    }

    public static void main(String[] args) {

    }
}
