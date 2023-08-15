package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: kep
 * @Date: 2023/8/13 19:28
 * @Description:
 */
public class LeetCode502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] pair = new int[profits.length][2];
        for(int i = 0;i<profits.length;i++){
            pair[i][0] = capital[i];
            pair[i][1] = profits[i];
        }
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int currentIndex = 0;
        for(int i = 0;i<k;i++){
            while (currentIndex < pair.length && w >= pair[currentIndex][0]){
                pq.add(pair[currentIndex][1]);
                currentIndex++;
            }
            if(pq.isEmpty()){
                break;
            }else{
                w += pq.poll();
            }
        }
        return w;
    }

    public static void main(String[] args) {
        new LeetCode502().findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1});
    }
}
