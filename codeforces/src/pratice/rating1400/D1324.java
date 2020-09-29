package pratice.rating1400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 此题用scanner会超时，因此需要使用BufferedReader和StringTokenizer 进行加速
 */
public class D1324 {
    private static final int MAX_N = 200001;
    private static Integer[] c = new Integer[MAX_N];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer a = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++) c[i] = Integer.parseInt(a.nextToken()) - Integer.parseInt(b.nextToken());
        Arrays.sort(c,0,n);
        long ans = 0;
        for(int i = 0;i<n;i++){
            int index = upper_bound(n-1,-c[i]);
            if(index > i){
                ans = ans + (n-index);
            }else{
                ans = ans + (n-1-i);
            }
        }
        System.out.println(ans);
    }

    private static int upper_bound(int r,long value){
        int  l = 0;
        while(l + 1 < r){
            int mid = (l+r)/2;
            if(c[mid] > value){
                r = mid;
            }else if(c[mid] <= value){
                l = mid +1;
            }
        }
        if(c[r] <= value){
            return r+1;
        }
        if(c[l] > value){
            return l;
        }
        return r;
    }

}
