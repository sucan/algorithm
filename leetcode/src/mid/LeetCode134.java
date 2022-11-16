package mid;

/**
 * @Auther: kep
 * @Date: 2022/9/10 16:25
 * @Description:
 */
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0;i<gas.length;){
            int sum = 0;
            int index = i;
            while(sum >= 0){
                sum += (gas[index] - cost[index]);
                if(sum < 0){
                    break;
                }
                index = (index+1)% gas.length;
                if(index == i){
                    return i;
                }
            }
            if(index + 1> i){
                i = index + 1;
            }else{
                break;
            }
        }
        return -1;
    }
}
