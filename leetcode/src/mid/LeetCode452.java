package mid;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: kep
 * @Date: 2023/8/5 21:10
 * @Description:
 */
public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int ans = 0;
        int index = 0;
        while(index < points.length){
            int nexIndex = index+1;
            int[] tmp = points[index];
            while(nexIndex < points.length){
                tmp = getIntersectInterval(tmp,points[nexIndex]);
                if(tmp[0] == -1){
                    break;
                }
                nexIndex++;
            }
            index = nexIndex;
            ans++;
        }
        return ans;
    }

    private int[] getIntersectInterval(int[] x,int[] y){
        int[] ans = {-1,-1};
        if(y[0] >= x[0] && y[0] <= x[1]){
            ans[0] = Math.max(x[0],y[0]);
            ans[1] = Math.min(x[1],y[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x  = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        new LeetCode452().findMinArrowShots(x);
    }

}
