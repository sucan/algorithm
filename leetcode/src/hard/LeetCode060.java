package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/29 01:48
 * @Description:
 */
public class LeetCode060 {
    public String getPermutation(int n, int k) {
        int[] sum = new int[n];
        boolean[] vis = new boolean[n+1];
        sum[0] = 1;
        for(int i = 1;i<n;i++){
            sum[i] = sum[i-1] * i;
        }
        return dfs(n,k,sum,vis);
    }

    //n位数的第k个排列
    private String dfs(int n,int k,int[] sum,boolean[] vis){
        if(n == 0){
            return "";
        }
        int x = k/sum[n-1];
        if(k%sum[n-1] != 0){
            x++;
        }
        int number = getNumber(x,vis);
        vis[number] = true;
        return number + dfs(n-1,k%sum[n-1] == 0?sum[n-1]:k%sum[n-1],sum,vis);
    }

    private int getNumber(int index,boolean[] vis){
        for(int i = 1;i<=vis.length-1;i++){
            if(!vis[i]){
                index--;
            }
            if(index == 0){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode060().getPermutation(3,3));
    }
}
