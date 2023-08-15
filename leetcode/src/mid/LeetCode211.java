package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/13 23:38
 * @Description:
 */
public class LeetCode211 {
    class Node {
        char val;
        boolean isLeaf;
        Node[] next = new Node[26];
    }
    private Node root = new Node();

    public void addWord(String word) {
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
       return dfs(0,word,root);
    }

    private boolean dfs(int index,String word,Node currentNode){
        if(index >= word.length()){
            return currentNode.isLeaf;
        }
        if(word.charAt(index) == '.'){
            for(int i = 0;i<26;i++){
                if(currentNode.next[i] != null) {
                    if (dfs(index + 1, word, currentNode.next[i])){
                        return true;
                    }
                }
            }
            return false;
        }else {
            int indexNum = word.charAt(index) - 'a';
            if(currentNode.next[indexNum] != null){
                return dfs(index + 1, word, currentNode.next[indexNum]);
            }else{
                return false;
            }
        }
    }
}
