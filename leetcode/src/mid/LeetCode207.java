package mid;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2023/8/6 19:36
 * @Description:
 */
public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        Set<Integer>[] edge = new HashSet[numCourses+1];
        int[]  inDegree = new int[numCourses+1];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<prerequisites.length;i++){
            if(edge[prerequisites[i][1]] == null || !edge[prerequisites[i][1]].contains(prerequisites[i][0])) {
                if(edge[prerequisites[i][1]] == null) {
                    edge[prerequisites[i][1]] = new HashSet<>();
                }
                edge[prerequisites[i][1]].add(prerequisites[i][0]);
                inDegree[prerequisites[i][0]]++;
            }
        }
        boolean[] vis = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            ans[index++] = tmp;
            vis[tmp] = true;
            if(edge[tmp] == null){
                continue;
            }
            for(int next:edge[tmp]){
                if(vis[next]){
                    continue;
                }
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        if(index != numCourses){
            return false;
        }
        return true;
    }
}
