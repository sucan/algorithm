package educationalCodeforcesRound93;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/15 12:12 PM
 */
public class ColoredRectangles {
    private static int[] R = new int[300];
    private static int[] G = new int[300];
    private static int[] B = new int[300];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        for(int i = 0;i<r;i++){
            R[i] = scanner.nextInt();
        }
        for(int i = 0;i<g;i++){
            G[i] = scanner.nextInt();
        }
        for(int i = 0;i<b;i++){
            B[i] = scanner.nextInt();
        }

    }
}
