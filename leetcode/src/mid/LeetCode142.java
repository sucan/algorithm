package mid;

/**
 * 当两个指针重合时
 * 设：a = 环外长度，b = 环内长度
 * 快指针是慢指针的两倍：fastIndex = 2 * slowIndex
 * 快指针比慢指针多走n个环：fastIndex = slowIndex + n*b
 * 因此慢指针走了n个环的距离：slowIndex = n*b
 *
 * 当位于环入口处时可能走了 a + n*b 步距离，因此slowIndex只需要再走a步即可到达环入口
 * 将快指针指为head，同慢指针一起每次走一步，直到相等时slowIndex刚好走过a步
 *
 * @Auther: kep
 * @Date: 2022/11/30 23:41
 * @Description:
 */
public class LeetCode142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fastIndex = head,slowIndex = head;
        while(true){
            if(fastIndex == null || fastIndex.next == null){
                return null;
            }
            fastIndex = fastIndex.next.next;
            slowIndex = slowIndex.next;
            if(fastIndex  == slowIndex){
                break;
            }
        }
        fastIndex = head;
        while (true){
            if(fastIndex == slowIndex){
                return slowIndex;
            }
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
    }
}
