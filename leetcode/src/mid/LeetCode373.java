package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Auther: kep
 * @Date: 2023/8/13 15:03
 * @Description:
 */
public class LeetCode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
//        boolean[][] vis = new boolean[nums1.length][nums2.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        for(int i = 0;i<Math.min(nums1.length,k)-1;i++){
            pq.add(new int[]{i,0});
        }
        while(ans.size() < k && !pq.isEmpty()){
            int[] point = pq.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums1[point[0]]);
            tmp.add(nums2[point[1]]);
            ans.add(tmp);
            if(point[1]+1 < nums2.length ){
                pq.add(new int[]{point[0],point[1]+1});
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode373().kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},10);
    }
}
