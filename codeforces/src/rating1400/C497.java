package rating1400;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class C497 {
    private static final int MAX_N = 100001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        TreeMap<Integer,Integer> aMinMap = new TreeMap<>();
        TreeMap<Integer,Integer> aMaxMap = new TreeMap<>();
        for(int i = 0;i<n;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Integer max_b  = aMaxMap.get(a);
            if(max_b == null || max_b < b){
                aMaxMap.put(a,b);
            }
            if(max_b == null || max_b > b){
                aMinMap.put(a,b);
            }
        }
        int ans = -1;
        for(Map.Entry<Integer,Integer> entry:aMaxMap.entrySet()){
            if(ans > aMinMap.get(entry.getKey())){
                ans = entry.getKey();
            }else{
                ans = entry.getValue();
            }
        }
        System.out.println(ans);
    }
}
