package mid;

public class LeetCode011 {
    /**
     * 贪心，在减少长度的同时尽可能增加高度
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left  = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int currentArea = (right - left) * Math.min(height[right],height[left]);
            if (currentArea > maxArea){
                maxArea = currentArea;
            }
            if (height[left] > height[right]){
                int tmpIndex = right;
                while(height[tmpIndex] == height[right]){
                    right--;
                }
            }else if(height[left] == height[right]){
                left++;
            }else{
                int tmpIndex = left;
                while(height[tmpIndex] == height[left]){
                    left++;
                }
            }
        }
        return maxArea;
    }
}
