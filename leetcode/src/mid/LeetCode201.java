package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/12 19:31
 * @Description:
 */
public class LeetCode201 {
    public int rangeBitwiseAnd(int left, int right) {
        if(findMaxIndex(left) != findMaxIndex(right)){
            return 0;
        }
        int maxIndex = findMaxIndex(left);
        int ans = 0;
        while(findMaxIndex(left) == findMaxIndex(right) && left > 0 && right > 0){
            if(maxIndex - 1 == 0){
                ans = ans | (left & right);
                break;
            }
            int leftBit = (left>>maxIndex-1) & 1;
            int rightBit = (right>>maxIndex-1) & 1;
            if((leftBit & rightBit) != 0) {
                ans |= 1 << maxIndex - 1;
            }
            if(leftBit != 0) {
                left -= 1 << maxIndex - 1;
            }
            if(rightBit != 0) {
                right -= 1 << maxIndex - 1;
            }
            maxIndex--;
        }
        return ans;
    }

    private int findMaxIndex(int num){
        int ans = 0;
        while(num != 0){
            ans++;
            num>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode201().rangeBitwiseAnd(5,5);
    }
}
