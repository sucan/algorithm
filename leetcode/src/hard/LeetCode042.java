package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/28 22:09
 * @Description:
 */
public class LeetCode042 {
    public int trap(int[] height) {
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for(int i = 0;i<height.length;i++){
            if(i == 0 || height[i] > left[i-1]){
                left[i] = height[i];
            }else{
                left[i] = left[i-1];
            }
        }
        for(int i = height.length-1;i>=0;i--){
            if(i == height.length-1 || height[i] > right[i+1]){
                right[i] = height[i];
            }else {
                right[i] = right[i+1];
            }
        }
        for(int i =0;i<height.length;i++){
            if(Math.min(left[i],right[i]) > height[i]) {
                ans += (Math.min(left[i], right[i]) - height[i]);
            }
        }
        return ans;
    }
}
