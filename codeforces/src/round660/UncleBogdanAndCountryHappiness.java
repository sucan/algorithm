package round660;

import java.util.*;

/**
 * codeforce link：https://codeforces.com/contest/1388/problem/C
 * Created by enpingkuang on 2020/8/3 9:39 PM
 */
public class UncleBogdanAndCountryHappiness {


    /**
     *
     * 按照题意上说的，h的取值只需要满足两个条件，就一定能有解：
     *
     *  1.对于任意一个节点，它的h[i]必须得是合法的
     *  2.对于任意一个节点，通过它时好心情的人数一定是大于通过它的所有子节点的好心情的人数的
     *  因为从一个节点到另一个节点的过程中，好心情的人数是只可能变少，不可能变多的
     *
     *
     * 同时我们假设经过一个节点的总人数为m,好心情的人的人数为x，坏心情的人数为y，那么可以得到如下式子：
     *
     * 1. x+y = m
     * 2. x-y = h
     *
     * => x = (m+h)/2
     * 而x的取值范围为 m >= x >= 0,并且x一定为整数，通过这个式子我们就能计算出x的取值了
     *
     *
     */
    private static int[] p = new int[100005];
    private static int[] h = new int[100005];
    private static boolean[] vis = new boolean[100005];
    private static Vector<Integer>[] G = new Vector[100005];

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int  t = scanner.nextInt();
        while(t -- > 0){
            int n = scanner.nextInt();
            for(int i = 0;i<=n;i++){
                G[i] = new Vector<>(0);
            }
            int m = scanner.nextInt();
            for(int i = 1;i<=n;i++){
                p[i] = scanner.nextInt();
            }
            for(int i = 1;i<=n;i++){
                h[i] = scanner.nextInt();
            }
            for(int i = 0;i<n-1;i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                G[a].addElement(b);
                G[b].addElement(a);
            }
            clean(n);
            countPeopleNum(1);
            clean(n);
            System.out.println(solve(1) == -1?"NO":"YES");
        }

    }


    private static int countPeopleNum(int index){
        vis[index] = true;
        int childrenNum = 0;
        for(Integer integer:G[index]){
            if(!vis[integer]) {
                childrenNum += countPeopleNum(integer);
            }
        }
        p[index] = p[index] + childrenNum;
        return p[index];
    }

    private static int solve(int index){
        vis[index] = true;
        if(!check(index)){
            return -1;
        }
        int childrenNum = 0;
        for(Integer integer:G[index]){
            if(vis[integer]){
                continue;
            }
            Integer tmp = solve(integer);
            if(tmp == -1){
                return -1;
            }
            childrenNum += tmp;
        }
        if((p[index] + h[index])/2 >= childrenNum){
            return (p[index] + h[index])/2 ;
        }
        return -1;
    }

    private static boolean check(int index){
        return (p[index] + h[index])/2 >=0 && (p[index] + h[index])/2 <= p[index] && (p[index] + h[index]) % 2 == 0;
    }

    private static void clean(int n){
        for(int i = 0;i<=n;i++){
            vis[i] = false;
        }
    }

}
