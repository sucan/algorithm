package abc178;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/9/19 4:15 下午
 */
public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[200005];
        int[] b = new int[200005];
        int left = -1,right = -1;
        int flag = -1;
        for(int i = 0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        for(int i = n-1;i>=0;i--){
            b[i] = scanner.nextInt();
            if(b[i] == a[i]){
                if(right == -1){
                    right = i;
                    flag = b[i];
                }
                left = i;
            }
        }
        int[] indexArray = new int[200005];
        int index = 0;
        for(int i = 0;i<n;i++){
            if(i == left){
                i = right;
                continue;
            }
            if(b[i] != flag && a[i] != flag){
                indexArray[index++] = i;
            }
        }
        if(left == -1 || index >= (right - left +1)){
            System.out.println("Yes");
            index = 0;
            for(int i = left;i<= right;i++){
                if (i == -1){
                    break;
                }
                int tmp = b[i];
                b[i] = b[indexArray[index]];
                b[indexArray[index]] = tmp;
                index++;
            }
            for(int i = 0;i<n;i++){
                if(i != 0) System.out.print(" ");
                System.out.print(b[i]);
            }
            System.out.println();
        }else{
            System.out.println("No");
        }

    }
}
