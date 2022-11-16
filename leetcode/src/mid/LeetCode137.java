package mid;

/**
 * 每个数出现的次数为1 或者 3，如果从二进制的角度考虑任何不为0的位1出现的次数一定是3或者1,为1的就是我们要的答案
 * @Auther: kep
 * @Date: 2022/9/10 16:53
 * @Description:
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0;i<32;i++){
            int bitValue = 0;
            for(int num:nums){
                bitValue +=  ((num>>i)&1);
                bitValue %= 3;
            }
            result |= (bitValue << i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        new LeetCode137().singleNumber(nums);
    }
}
