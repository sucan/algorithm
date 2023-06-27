package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kep
 * @Date: 2023/5/5 22:25
 * @Description:
 */
public class LeetCode149 {
    public int maxPoints(int[][] points) {
        int max = 0;
        for(int i = 0;i<points.length;i++){
            Map<Long,Integer> map = new HashMap<>();
            for(int j = i+1;j<points.length;j++){
                Long slope  = getSlope(points[i],points[j]);
                Integer nums = map.get(slope);
                if(map.get(slope) == null){
                    nums = 1;
                }
                nums++;
                map.put(slope,nums);
                max = Math.max(max,nums);
            }
        }
        return max;
    }

    private long getSlope(int[] point1,int[] point2){
        int y  = (point2[1]-point1[1]);
        int x = (point2[0]-point1[0]);
        if(y == 0){
            return 200001;
        }
        if(x == 0){
            return 200002;
        }
        int gcd = getGcd(Math.abs(y),Math.abs(x));
        long result = Math.abs(y/gcd * 100000L) + Math.abs(x/gcd);
        if(sameSign(x,y)){
            return result;
        }
        return -result;
    }

    private int getGcd(int a,int b){
        if(b == 0){
            return a;
        }
        return getGcd(b,a%b);
    }

    boolean sameSign(int a, int b) {
        if ( a >= 0 )
            return b >= 0;
        else
            return b < 0;
    }

    public static void main(String[] args) {
        int[][] input = {{2,3},{3,3},{-5,3}};
        new LeetCode149().maxPoints(input);
    }
}
