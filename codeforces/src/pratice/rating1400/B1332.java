package pratice.rating1400;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 枚举所有质数，然后判断是否可用
 */
public class B1332 {
    private static final int MAX_N = 200001;
    private static Integer[] a = new Integer[MAX_N];
    private static Integer[] prime = new Integer[MAX_N];
    private static boolean[] vis = new boolean[MAX_N];

    private static void init(){
        int index = 0;
        for(int i = 2;i*i<=1000;i++){
            if(!vis[i]){
                prime[index++] = i;
            }
            for(int j = 2;j*i<=1000;j++){
                vis[i*j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        init();
        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            Integer[] ans = new Integer[n];
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                a[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int index = 0;
            for (int j = 0; j < 11; j++) {
                boolean used = false;
                for(int i = 0;i<n;i++) {
                    if(ans[i] == null && a[i] % prime[j] == 0) {
                        if(!used){
                            index++;
                            used = true;
                        }
                        ans[i] = index;
                    }
                }

            }
            System.out.println(index);
            for(int i = 0;i<n;i++){
                if(i != 0){
                    System.out.print(" ");
                }
                System.out.print(ans[i]);
            }
            System.out.println();
        }
    }

    private static int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }

}
