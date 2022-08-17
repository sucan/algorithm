package mid;

/**
 * @Auther: kep
 * @Date: 2021/9/11 14:47
 * @Description:
 */
public class LeetCode056 {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        sort(intervals,0,intervals.length-1);
        int index = 0;
        int start = -1;
        int last = -1;
        for(int i = 0;i<intervals.length;i++){
            if(i == 0){
                start = intervals[0][0];
                last = intervals[0][1];
                continue;
            }
            if(intervals[i][0] > last){
                result[index][0] = start;
                result[index][1] = last;
                index++;
                start = intervals[i][0];
                last = intervals[i][1];
            }else {
                last = Math.max(last, intervals[i][1]);
            }
        }
        result[index][0] = start;
        result[index][1] = last;
        int[][] ans = new int[index+1][2];
        for(int i = 0;i<=index;i++){
            ans[i][0] = result[i][0];
            ans[i][1] = result[i][1];
        }
        return ans;
    }

    public void sort(int[][] intervals,int l,int r){
        if(l >= r){
            return;
        }
        int[] tmp = new int[2];
        tmp[0] = intervals[l][0];
        tmp[1] = intervals[l][1];
        int index = l;
        int left = l,right = r;
        while(left < right){
            while(right > left && intervals[right][0] >= tmp[0])right--;
            intervals[index] = intervals[right];
            index = right;
            while(left < right && intervals[left][0] <= tmp[0])left++;
            intervals[index] = intervals[left];
            index = left;
        }
        intervals[index] = tmp;
        sort(intervals,l,index-1);
        sort(intervals,index+1,r);
    }

    public static void main(String[] args) {
        int[][] arrays = {{1,4},{0,4}};
        new LeetCode056().merge(arrays);
    }
}
