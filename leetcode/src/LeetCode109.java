/**
 * 链表的顺序刚好是中序遍历的顺序
 * @Auther: kep
 * @Date: 2022/8/15 22:00
 * @Description:
 */
public class LeetCode109 {
    private ListNode gHead;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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

    public TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);
        gHead = head;
        return buildTree(1,length);
    }

    private TreeNode buildTree(int index,int length){
        if(index > length){
            return null;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.left = buildTree(index*2,length);
        treeNode.val = gHead.val;
        gHead = gHead.next;
        treeNode.right = buildTree(index*2+1,length);
        return treeNode;
    }

    private int getLength(ListNode head){
        ListNode tmp = head;
        int length = 0;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }
}
