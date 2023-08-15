package hard;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2023/8/13 23:50
 * @Description:
 */
public class LeetCode212 {
    class Node {
        char val;
        boolean isLeaf;
        String path = "";
        Node[] next = new Node[26];
    }
    private Node root = new Node();
    private int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private Set<String> ans = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        ans.clear();
        boolean[][] vis = new boolean[board.length][board[0].length];
        buildTree(words);
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                dfs(i,j,board,vis,root);
            }
        }
        return new ArrayList<>(ans);
    }

    private void buildTree(String[] words){
        for(String word:words){
            Node tmp = root;
            for(int i = 0;i<word.length();i++){
                int index = word.charAt(i) -'a';
                if(tmp.next[index] == null){
                    Node node = new Node();
                    node.val = word.charAt(i);
                    node.path = tmp.path + word.charAt(i);
                    tmp.next[index] = node;
                }
                tmp = tmp.next[index];
            }
            tmp.isLeaf = true;
        }
    }

    private void dfs(int x,int y,char[][] board,boolean[][] vis,Node node){
        if(x < 0 || x >= board.length || y < 0 || y >= board[y].length || vis[x][y]){
           return;
        }
        int index = board[x][y] -'a';
        if(node.next[index] == null){
            return;
        }
        if(node.next[index].isLeaf){
            ans.add(node.next[index].path);
        }
        vis[x][y] = true;
        for(int i = 0;i<4;i++){
            dfs(x + dir[i][0],y + dir[i][1],board,vis,node.next[index]);
        }
        vis[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a'}};
        String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        new LeetCode212().findWords(board,words);
    }
}
