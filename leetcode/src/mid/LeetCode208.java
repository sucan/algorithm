package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/13 23:29
 * @Description:
 */
public class LeetCode208 {
    class Trie {
        class Node {
            char val;
            boolean isLeaf;
            Node[] next = new Node[26];
        }
        private Node root = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node current = root;
            for(int i = 0;i<word.length();i++){
                int index = word.charAt(i) -'a';
                if(current.next[index] != null){
                    current = current.next[index];
                }else{
                    Node node = new Node();
                    node.val = (char)('a' + index);
                    current.next[index] = node;
                    current = node;
                }
            }
            current.isLeaf = true;
        }

        public boolean search(String word) {
            Node current = root;
            for(int i = 0;i<word.length();i++){
                int index = word.charAt(i) -'a';
                if(current.next[index] != null){
                    current = current.next[index];
                }else{
                   return false;
                }
            }
            return current.isLeaf;
        }

        public boolean startsWith(String word) {
            Node current = root;
            for(int i = 0;i<word.length();i++){
                int index = word.charAt(i) -'a';
                if(current.next[index] != null){
                    current = current.next[index];
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
