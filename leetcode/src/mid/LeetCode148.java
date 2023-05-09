package mid;

/**
 * 归并排序或者堆排序
 * @Auther: kep
 * @Date: 2023/4/23 23:42
 * @Description:
 */
public class LeetCode148 {

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

    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        int step = 1;
        ListNode emptyHead = new ListNode();
        emptyHead.next = head;
        for(int i = step;i<length;i*=2){
            ListNode currentNode = emptyHead.next;
            ListNode preHead = emptyHead;
            ListNode s1Head = null;
            ListNode s2Head = null;
            while(currentNode != null) {
                s1Head = currentNode;
                for(int j = 1;j<i && currentNode.next != null;j++){
                    currentNode = currentNode.next;
                }
                s2Head = currentNode.next;
                currentNode.next = null;
                currentNode = s2Head;
                for(int j = 1;j<i && currentNode != null;j++){
                    currentNode = currentNode.next;

                }
                if(currentNode != null){
                    ListNode next = currentNode.next;
                    currentNode.next = null;
                    currentNode = next;
                }
                preHead.next = mergeList(s1Head, s2Head);
                    while(preHead.next != null){
                        preHead = preHead.next;
                    }



            }
        }
        return emptyHead.next;
    }

    private ListNode mergeList(ListNode s1,ListNode s2){
        ListNode emptyNode = new ListNode();
        ListNode tmp = emptyNode;
        ListNode tmp1 = s1;
        ListNode tmp2 = s2;
        while(tmp1 != null || tmp2 != null){
            if(tmp1 == null){
                tmp.next = tmp2;
                tmp2= tmp2.next;
            }else if(tmp2 == null){
                tmp.next = tmp1;
                tmp1= tmp1.next;
            }else if(tmp1.val < tmp2.val){
                tmp.next = tmp1;
                tmp1= tmp1.next;
            }else{
                tmp.next = tmp2;
                tmp2= tmp2.next;
            }
            tmp = tmp.next;
        }
        return emptyNode.next;
    }

    private int getLength(ListNode head){
        int x = 0;
        ListNode tmp = head;
        while(tmp !=null){
            tmp = tmp.next;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = -1;
        ListNode next = new ListNode();
        next.val = 5;
        head.next = next;
        ListNode next2 = new ListNode();
        next2.val = 3;
        next.next = next2;
        ListNode next3 = new ListNode();
        next3.val = 4;
        next2.next = next3;
        ListNode next4 = new ListNode();
        next4.val = 0;
        next3.next = next4;
        new LeetCode148().sortList(head);
    }
}
