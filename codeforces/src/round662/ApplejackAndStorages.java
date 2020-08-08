package round662;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/8 12:54 PM
 */
public class ApplejackAndStorages {

    private static int[] a = new int[100005];
    private static int x = 0,y = 0,z = 0,w = 0;

    /**
     * x,y,z,w 的含义分别如下：
     *
     * x：数量 >= 8 的 木板个数
     * y：数量 < 8  &&  >= 6 的 木板个数
     * z：数量 < 6  && >= 4 的木板个数
     * w: 数量 < 4 && >= 2 的木板个数
     *
     *
     * 只需要每次加减木板的时候，维护x,y,z,w的值，然后做一下判断即可
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0;i<n;i++){
            int tmp = scanner.nextInt();
            a[tmp]++;
            changeUp(tmp);
        }
        int q = scanner.nextInt();
        for(int i = 0;i<q;i++){
            String operator = scanner.next();
            int value = scanner.nextInt();
            if("+".equals(operator)){
                a[value]++;
                changeUp(value);
            }else{
                a[value]--;
                changeDown(value);
            }
            System.out.println(solve());
        }
    }

    private static void changeUp(int tmp){
        if(a[tmp] == 2)w++;
        if(a[tmp] == 4){z++;w--;}
        if(a[tmp] == 6){y++;z--;}
        if(a[tmp] == 8){x++;y--;}
    }

    private static void changeDown(int tmp){
        if(a[tmp] == 1)w--;
        if(a[tmp] == 3){z--;w++;}
        if(a[tmp] == 5){y--;z++;}
        if(a[tmp] == 7){x--;y++;}
    }



    private static String solve(){
        if(x > 0 || y > 1 || z > 1){
            return "YES";
        }
        if(y == 1 && (z > 0 || w > 0)){
            return "YES";
        }
        if(z  == 1 && w > 1){
            return "Yes";
        }
        return "NO";
    }
}
