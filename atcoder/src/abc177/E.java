package abc177;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/11 11:31 下午
 */
public class E {
    private static int[] prime = new int[1000001];
    private static int[] factor = new int[1000005];
    private static boolean[] vis = new boolean[1000001];

    private static int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }

    private static void getPrime(){
        for(int i = 2;i<=1000000;i++){
            if(prime[i] == 1){
                continue;
            }
            factor[i] = i;
            for(int j = 2;j*i<=1000000;j++){
                factor[j * i] = i;
                prime[j*i] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getPrime();
        boolean first = true;
        boolean second = false;
        int tmp_gcd = 0;
        for(int i = 0;i<n;i++){
            int x = scanner.nextInt();
            first = resolve(first,x);
            tmp_gcd = gcd(x,tmp_gcd);
            if(tmp_gcd == 1){
                second = true;
            }
        }
        if(first){
            System.out.println("pairwise coprime");
        }else{
            if(second){
                System.out.println("setwise coprime");
            }else{
                System.out.println("not coprime");
            }
        }
    }

    private static boolean resolve(boolean flag,int x){
        if (!flag) {
            return false;
        }
        while (x != 1) {
            if(vis[factor[x]]){
                return false;
            }
            vis[factor[x]] = true;
            int tmp = factor[x];
            x /= factor[x];
            while(x!= 1 && tmp == factor[x]) {
                x /= factor[x];
            }
        }
        return true;
    }
}
