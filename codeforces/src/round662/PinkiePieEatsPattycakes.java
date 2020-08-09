package round662;

import java.util.Scanner;

/**
 * Created by enpingkuang on 2020/8/9 4:36 PM
 */
public class PinkiePieEatsPattycakes {


    /**
     *  由题意很容易能够想到的一个点就是，最大的最短距离是和出现次数最多的数的个数和出现次数相关的
     *  那么具体的关系又是什么呢，我们设最大的最短距离为 dis,出现次数最多的数的出现次数为max，这类数一共有maxCount个
     *
     *  先来看一个实际例子,假设总共有9个数,出现次数最大的数出现次数为3，这类数一共有1个为1，那么最优的排列应该是：
     *
     *  1 ? ? ? 1 ? ? ? 1
     *
     *  当这类数有2个，分别为1，2的时候，最优的排列为:
     *
     *  1 2 ? 1 2 ? 1 2 ?
     *
     *  当这类数有3个，分别为1，2，3的时候，最优的排列为:
     *
     *  1 2 3 1 2 3 1 2 3
     *
     *  我们从这个例子可以看出，要使得最短距离最大，那么最佳的排列方式一定是把出现次数最多的数按序放在一起，然后让它们尽可能地平均分布在数列中
     *
     *  例如出现次数最多的数为 1，2，3，4，那么一个最优的数列一定是：
     *
     *  （1，2，3，4),......(1,2,3,4),......(1,2,3,4)......
     *
     *  其中分号部分可能为空
     *
     *  当我们看出这个规律的时候，我们就可以写出最短距离的表达式了：
     *
     *  dis = (maxCount - 1) + (n - maxCount * max)/(max - 1)
     *
     *
     *
     *
     *
     */


    private static int[] a = new int[100005];

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            init(n);
            for(int i = 0;i<n;i++){
                int tmp = scanner.nextInt();
                a[tmp]++;
            }
            int max = 0;
            int maxCount = 0;
            for(int i = 0;i<=n;i++){
                if(max < a[i]){
                    max = a[i];
                    maxCount = 1;
                }else if(max == a[i]){
                    maxCount++;
                }
            }
            System.out.println((n - (maxCount * max))/(max-1) + (maxCount - 1));
        }

    }

    private static void init(int n ){
        for(int i = 0;i<=n;i++){
            a[i]=0;
        }
    }

}
