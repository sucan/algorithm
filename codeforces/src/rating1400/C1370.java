package rating1400;

import java.util.Scanner;

/**
 * n 为1 时先手必败
 * n 为2 时先手必胜
 * n >= 3时
 *  n为奇数，先手必胜
 *  n为偶数时
 *      n若为2的整数幂，例如4，8，16等，先手必败
 *      n能写作 pow(2,k) * p 时，k >=2 ,p为素数，先手必胜
 *      n为 2*q,q为一个或者多个素数的乘积
 *          当q为一个素数时，先手必败
 *          当q为多个素数的乘积时，先手必胜
 */
public class C1370 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            if(n == 1){
                System.out.println("FastestFinger");
            }else if(n == 2){
                System.out.println("Ashishgup");
            }else{
                if(n%2 == 1){
                    System.out.println("Ashishgup");
                }else{
                    if(isEve(n)){
                        System.out.println("FastestFinger");
                    }else{
                        boolean flag = false;
                        for(int i = 4;i< n;i*=2){
                            if(n % i == 0 && (n/i) % 2 == 1){
                                flag = true;
                                break;
                            }
                        }
                        if(flag){
                            System.out.println("Ashishgup");
                        }else{
                            if(isPrime(n/2)){
                                System.out.println("FastestFinger");
                            }else{
                                System.out.println("Ashishgup");
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isEve(int n){
        int count = 0;
        while(n !=0){
            count += n&1;
            n>>=1;
        }
        return count == 1;
    }

    private static boolean isPrime(int n){
        for(int i = 2;i*i<= n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
