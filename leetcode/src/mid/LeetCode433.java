package mid;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2023/8/16 00:09
 * @Description:
 */
public class LeetCode433 {
    class Node{
        int index;
        String val;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return index == node.index &&
                    Objects.equals(val, node.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, val);
        }
    }
    Map<String,Integer> valueMap = new HashMap<>();
    Map<Integer,Set<Integer>> edge = new HashMap<>();
    public int minMutation(String startGene, String endGene, String[] bank) {
        int sIndex = addStr(startGene);
        for(String value:bank){
            addStr(value);
        }
        if(valueMap.get(endGene) == null){
            return -1;
        }
        int eIndex = addStr(endGene);
        if(sIndex == eIndex){
            return 0;
        }
        List<String> valueList = new ArrayList<>(valueMap.keySet());
        for(int i = 0;i<valueList.size();i++){
            for(int j = i+1;j<valueList.size();j++){
                if(canConnect(valueList.get(i),valueList.get(j))){
                    int targetIndex = valueMap.get(valueList.get(i));
                    int sourceIndex = valueMap.get(valueList.get(j));
                    edge.computeIfAbsent(targetIndex,k -> new HashSet<>()).add(sourceIndex);
                    edge.computeIfAbsent(sourceIndex,k -> new HashSet<>()).add(targetIndex);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[valueList.size()];
        boolean hasAns = false;
        q.add(sIndex);
        vis[sIndex] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int tmp = q.poll();
                if(tmp == eIndex){
                    hasAns = true;
                    break;
                }
                Set<Integer> edges = edge.get(tmp);
                if(edges != null) {
                    for (Integer source : edges) {
                        if(!vis[source]){
                            vis[source] = true;
                            q.add(source);
                        }
                    }
                }

            }
            if(hasAns){
                break;
            }
            level++;

        }
        return !hasAns?-1:level;
    }

    private boolean canConnect(String a,String b){
        int diffCount = 0;
        if(a.length() != b.length()){
            return false;
        }
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                diffCount++;
            }
            if(diffCount > 1){
                return false;
            }
        }
        return diffCount == 1;
    }

    private int addStr(String value){
        return valueMap.computeIfAbsent(value,k -> valueMap.size());
    }

    public static void main(String[] args) {
        new LeetCode433().minMutation("AACCGGTT","AACCGGTA",new String[]{});
    }


}
