package mid;

/**
 * @Auther: kep
 * @Date: 2023/8/12 19:23
 * @Description:
 */
public class LeetCode172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        for(int i = 1;i<=n;i++){
            ans += solve(i);
        }
        return ans;
    }

    public int solve(int num){
        int ans = 0;
        while(num != 0 && num % 5 == 0){
            ans++;
            num/=5;
        }
        return ans;
    }

}
