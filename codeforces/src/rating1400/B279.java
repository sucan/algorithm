package rating1400;

import java.util.Scanner;

public class B279 {
    private static final int MAX_N = 100001;
    private static int[] a = new int[MAX_N];
    private static long[] sum = new long[MAX_N<<1];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        for(int i = 0;i<n;i++) {
            a[i] = scanner.nextInt();
        }
        for(int i = 1;i<=n;i++){
            sum[i] =  sum[i-1] + a[i-1];
        }
        int ans = 0;
        for(int i = 1;i<=n;i++){
            int index = upper_bound(sum,i,n,sum[i-1] + t );
            ans = Math.max(ans,index-i);
        }
        System.out.println(ans);
    }

    private static int upper_bound(long[] v,int l,int r,long t){
        while(l <= r){
            int mid = (l +r)/2;
            if(v[mid] <= t){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
