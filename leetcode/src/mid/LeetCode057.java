package mid;

import java.util.Arrays;

/**
 * @Auther: kep
 * @Date: 2022/4/22 20:49
 * @Description:
 */
public class LeetCode057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length][2];
        int tmp = 0;
        int inserted = 0;
        int mergeNum = 0;
        for(int i = 0;i<intervals.length;){
            if(intervals[i][0] >= newInterval[0] && inserted == 0){
                inserted = 1;
                if(tmp == 0){
                    result[tmp++] =  newInterval;
                }else{
                    if(checkIntersect(result[tmp-1],newInterval) == 0){
                        result[tmp-1][1] =Math.max(result[tmp-1][1],newInterval[1]);
                        mergeNum++;
                    }else{
                        result[tmp++] = newInterval;
                    }
                }
            }else{
                if(tmp == 0){
                    result[tmp++] =  intervals[i];
                }else{
                    if(checkIntersect(result[tmp-1],intervals[i]) == 0){
                        result[tmp-1][1] = Math.max(result[tmp-1][1],intervals[i][1]);
                        mergeNum++;
                    }else{
                        result[tmp++] = intervals[i];
                    }
                }
                i++;
            }
        }
        return Arrays.copyOf(result,intervals.length + 1 - mergeNum);
    }

    public int checkIntersect(int[] a,int[] b){
        if(b[1] < a[0]){
            return -1;
        }
        if(b[0] >= a[0] && b[0] <= a[1]){
            return 0;
        }
        return 1;
    }
}
