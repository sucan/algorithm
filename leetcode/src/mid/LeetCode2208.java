package mid;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Auther: kep
 * @Date: 2023/8/3 23:16
 * @Description:
 */
public class LeetCode2208 {
    public int halveArray(int[] nums) {
        int ans = 0;
        double sum = 0;
        Queue<Double> q = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1.equals(o2)){
                    return 0;
                }
                return o2 - o1 > 0?1:-1;
            }
        });
        for(int num:nums){
            q.add((double)num);
            sum+=num;
        }
        double target = sum/2;
        while (sum > target){
            double tmp = q.poll();
            sum -= tmp/2;
            q.add(tmp/2);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,19,8,1};
        new LeetCode2208().halveArray(nums);
    }
}
