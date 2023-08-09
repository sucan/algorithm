package hard;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2023/8/5 11:58
 * @Description:
 */
public class LeetCode127 {
    class Node {
        private int index;
        private int level = Integer.MAX_VALUE;
        private String value;
        private List<Node> pre = new LinkedList<>();
        private List<Node> next = new LinkedList<>();

        public Node(int index,String value){
            this.index = index;
            this.value = value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        boolean[][] vis = new boolean[wordList.size()+2][wordList.size()+2];
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return ans;
        }
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        Queue<Node> q = new LinkedList<>();
        Node s = new Node(0,beginWord);
        Node e = new Node(wordSet.size()+1,endWord);
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(s);
        nodeList.add(e);
        int index = 1;
        for(String value:wordSet){
            nodeList.add(new Node(index++,value));
        }
        for(int i = 0;i<nodeList.size();i++){
            for(int j = i+1;j<nodeList.size();j++){
                Node a = nodeList.get(i);
                Node b = nodeList.get(j);
                if(canConvert(a.value,b.value)){
                    a.next.add(b);
                    b.next.add(a);
                }
            }
        }
        s.level = 0;
        s.pre.add(null);
        q.add(s);
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Node tmp = q.poll();
                if(tmp.index == wordSet.size() + 1){
                    flag = true;
                    return ans;
                }
                for (Node next : tmp.next) {
                    if (!vis[next.index][tmp.index] && tmp.level + 1 <= next.level) {
                        next.pre.add(tmp);
                        next.level = tmp.level + 1;
                        q.add(next);
                        vis[next.index][tmp.index] = vis[tmp.index][next.index] = true;
                    }
                }
            }
            if (flag) {
                break;
            }
        }

        return 0;
    }

    private void buildSubStr(Node tmp,List<List<String>> ans,List<String> sub){
        if(tmp == null){
            List<String> xx = new ArrayList<>(sub);
            Collections.reverse(xx);
            ans.add(xx);
            return;
        }
        for(Node pre:tmp.pre) {
            sub.add(tmp.value);
            buildSubStr(pre, ans,sub);
            sub.remove(sub.size()-1);
        }
    }


    private boolean canConvert(String a,String b){
        if(a.length() != b.length()){
            return false;
        }
        int count = 0;
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
            if(count == 2){
                return false;
            }
        }
        return true;
    }
}
