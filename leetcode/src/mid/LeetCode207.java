package mid;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2023/8/6 19:36
 * @Description:
 */
public class LeetCode207 {

    private boolean ans = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> next = edges.computeIfAbsent(prerequisites[i][0],(k) ->  new ArrayList<Integer>());
            next.add(prerequisites[i][1]);
        }
        for(int i = 0;i<numCourses;i++){
            if(vis[i] != 0){
                vis[i] = 1;
                dfs(i,edges,vis);
                vis[i] = 2;
                if(ans){
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int i,Map<Integer, List<Integer>> edges,int[] vis){
        for(Integer next:edges.get(i)){

        }
    }
}
