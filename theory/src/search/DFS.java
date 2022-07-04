package search;

/**
 * @Auther: kep
 * @Date: 2022/7/2 18:36
 * @Description:
 */
public class DFS {

    private void dfs(int index,int numsIndex,int n,int[] nums){
        if(numsIndex == n+1){
            for(int i = 1;i<=n;i++){
                System.out.print(nums[i]+" ");
            }
            System.out.println();
            return;
        }
        if(index > n){
            return;
        }
        for(int i = index;i<=n;i++){
            nums[numsIndex] = i;
            dfs(i+1,numsIndex+1,n,nums);
        }
    }

    private void dfs_2(int numsIndex,int n,int[] nums,boolean[] vis){
        if(numsIndex == n+1){
            for(int i = 1;i<=n;i++){
                System.out.print(nums[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1;i<=n;i++){
            if(!vis[i]){
                vis[i] = true;
                nums[numsIndex] = i;
                dfs_2(numsIndex+1,n,nums,vis);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new DFS().dfs_2(1,4,new int[100],new boolean[100]);
    }
}
