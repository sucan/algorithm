package easy;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:32
 * @Description:
 */
public class LeetCode1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] xx = new int[101];
        for(int i = 0;i<nums.length;i++){
            xx[nums[i]]++;
        }
        int ans = 0;
        for(int i = 1;i<=100;i++){
            if(xx[i] >= 2){
                ans += ((xx[i]-1) * xx[i] /2);
            }
        }
        return ans;
    }
}
