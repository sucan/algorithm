package abc176;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/11 11:31 下午
 */
public class E {


    private static final int MAX_N = 300005;
    static int[] tmp_h = new int[MAX_N];
    static int[] tmp_w = new int[MAX_N];
    static int[] count_h = new int[MAX_N];
    static int[] count_w = new int[MAX_N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int m = scanner.nextInt();
        int max_h = 0;
        int max_h_index = -1;
        int max_w = 0;
        int max_w_index = -1;
        for (int i = 0; i < m; i++) {
            tmp_h[i] = scanner.nextInt();
            tmp_w[i] = scanner.nextInt();
            count_h[tmp_h[i]]++;
            count_w[tmp_w[i]]++;
            if (count_h[tmp_h[i]] > max_h) {
                max_h = count_h[tmp_h[i]];
                max_h_index = tmp_h[i];
            }
            if (count_w[tmp_w[i]] > max_w) {
                max_w = count_w[tmp_w[i]];
                max_w_index = tmp_w[i];
            }
        }
        init();
        int ans = 0;
        if(max_h >= max_w){
            ans = ans + max_h;
            max_w = 0;
            for(int i = 0;i<m;i++){
                if(tmp_h[i] == max_h_index){
                    continue;
                }
                count_w[tmp_w[i]]++;
                if (count_w[tmp_w[i]] > max_w) {
                    max_w = count_w[tmp_w[i]];
                }
            }
            ans += max_w;
        }else{
            ans = ans + max_w;
            max_h = 0;
            for(int i = 0;i<m;i++){
                if(tmp_w[i] == max_w_index){
                    continue;
                }
                count_h[tmp_h[i]]++;
                if (count_h[tmp_h[i]] > max_h) {
                    max_h = count_h[tmp_h[i]];
                }
            }
            ans += max_h;

        }
        System.out.println(ans);
    }

    private static void init(){
        for(int i = 0;i<MAX_N;i++){
            count_h[i] = count_w[i] = 0;
        }
    }

}
