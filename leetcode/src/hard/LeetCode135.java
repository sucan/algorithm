package hard;

/**
 * @Auther: kep
 * @Date: 2023/8/5 19:56
 * @Description:
 */
public class LeetCode135 {
    public int candy(int[] ratings) {
        int[] values = new int[ratings.length];
        for(int i = 0;i<values.length;i++){
            values[i] = 1;
        }
        for(int i = 1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                values[i] = Math.max(values[i],values[i-1]+1);
            }
        }
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                values[i] = Math.max(values[i],values[i+1]+1);
            }
        }
        int ans = 0;
        for(int i = 0;i<values.length;i++){
            ans +=values[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] xx = {1,0,2};
        new LeetCode135().candy(xx);
    }
}
