package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/5 19:28
 * @Description:
 */
public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        boolean[] vis = new boolean[nums.length];
        for(int i = 0;i<nums.length;i++) {
            int nextIndex = (i + k) % nums.length;
            int tmpValue = nums[i];
            while (!vis[nextIndex]) {
                vis[nextIndex] = true;
                int tmp = nums[nextIndex];
                nums[nextIndex] = tmpValue;
                tmpValue = tmp;
                nextIndex = (nextIndex + k) % nums.length;
            }
        }
    }
}
