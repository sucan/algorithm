package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:23
 * @Description:
 */
public class LeetCode045 {
    public int jump(int[] nums) {
        int current = 0;
        int step = 0;
        while(current < nums.length - 1){
            int tmp = current + nums[current];
            int tmpIndex = current;
            if(tmp >= nums.length -1){
                step++;
                break;
            }
            for(int i = current;i< nums.length && i<= current+nums[current];i++){
                if(i + nums[i] >= tmp){
                    tmp = i + nums[i];
                    tmpIndex = i;
                }
            }
            current = tmpIndex;
            step++;
        }
        return step;
    }
}
