package round669;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/8 10:51 下午
 */
public class Ahahahahahahahaha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int[] a = new int[10000];
            int[] ans = new int[10000];
            int index = 0;
            int n = scanner.nextInt();
            int oneIndex = -1;
            for(int i = 0;i<n;i++){
                a[i] = scanner.nextInt();
                if(a[i] == 1){
                    if(oneIndex == -1){
                        oneIndex = index;
                    }else{
                        if((index - oneIndex)%2 == 0){
                            index--;
                        }
                        oneIndex = -1;
                    }
                }
                ans[index++] = a[i];
            }
            System.out.println(index - (oneIndex == -1?0:1));
            boolean flag = false;
            for(int i = 0;i<index;i++){
                if(oneIndex == i){
                    continue;
                }
                if(flag){
                    System.out.print(" ");
                }
                System.out.print(ans[i]);
                flag = true;
            }
            System.out.println();
        }
    }
}
