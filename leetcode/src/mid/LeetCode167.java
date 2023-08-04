package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/3 22:26
 * @Description:
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        ans[0] = 0;
        ans[1] = numbers.length-1;
        while(ans[0] < ans[1]){
            if(numbers[ans[0]] + numbers[ans[1]] == target){
                break;
            }else if(numbers[ans[0]] + numbers[ans[1]] < target){
                ans[0]++;
            }else {
                ans[1]--;
            }
        }
        return ans;
    }
}
