package abc177;

import java.util.*;

/**
 * 官方题解的解法：
 *
 * 维护W个区间[start,end] ，start表示从第一行的第start个点出发，end表示达到当前行时能够到达的最左边的点
 * 对于每一行的每个区间，其更新策略为：如果 B[i] >= end >= A[i],则将区间更新为 [start,B[i] + 1] ,如果B[i] + 1 > W ,则更新为 [start,+无穷]
 * 对于样例1来说:
 * 初始状态的W为  [1,1] [2,2] [3,3] [4,4]      ans = 0
 * 第二行的W为：  [1,2] [2,5] [3,5] [4,5]      ans = 2-1 = 1
 * 第三行的W为   [1,4] [2,5] [3,5] [4,5]       ans = 4-1 = 3
 * 第四行的W为   [1,5] [2,5] [3,5] [4,5]       ans = -1
 *
 *
 * 那么对于每一行而言，答案就是 min(W[i].end-W[i].start) (w>= i >=1)
 *
 * 对于实现方案，官方说有两种，一种用线段树一种用set+mutilSet
 *
 *
 *
 * Created by enpingkuang on 2020/9/12 6:54 下午
 */
public class F {
    static class Node{
        int preShortestPath;
        int leftPoint;
        Node(int preShortestPath,int leftPoint){
            this.preShortestPath = preShortestPath;
            this.leftPoint = leftPoint;
        }
    }

    private static Node[] lazy = new Node[200005<<2];

    private static int[] segmentTree = new int[200005<<2];

    /**
     *
     * @param nowIndex 当前节点数组下标
     * @param l 当前节点区间
     * @param r 当前节点区间
     * @param L 操作区间
     * @param R 操作区间
     * @return
     */
    private static int query(int nowIndex,int l,int r,int L,int R){
        if(l== L && r == R){
            return segmentTree[nowIndex];
        }
        pushDown(nowIndex,l,r);
        int mid = (l+r)>>1;
        if(R <= mid){
            return query(nowIndex<<1,l,mid,L,R);
        }else if(L > mid){
            return query(nowIndex<<1|1,mid+1,r,L,R);
        }else{
            return Math.min(query(nowIndex<<1,l,mid,L,mid),query(nowIndex<<1|1,mid+1,r,mid+1,R));
        }
    }

    private static void pushDown(int nowIndex,int l,int r){
        if(lazy[nowIndex] != null){
            segmentTree[nowIndex<<1] = lazy[nowIndex].preShortestPath + l - lazy[nowIndex].leftPoint;
            segmentTree[nowIndex<<1|1] = lazy[nowIndex].preShortestPath + (l+r)/2 + 1 - lazy[nowIndex].leftPoint;
            lazy[nowIndex<<1] = new Node(lazy[nowIndex].preShortestPath,lazy[nowIndex].leftPoint);
            lazy[nowIndex<<1|1] = new Node(lazy[nowIndex].preShortestPath,lazy[nowIndex].leftPoint);
            lazy[nowIndex] = null;
        }
    }

    private static void update(int nowIndex,int l,int r,int L,int R,int dis,int leftPoint){
        if(L <= l && r <= R){
            segmentTree[nowIndex] = dis + l - leftPoint;
            lazy[nowIndex] = new Node(dis,leftPoint);
            return ;
        }
        int m=(l+r)>>1;
        pushDown(nowIndex,l,r);
        if(L <= m) update(nowIndex<<1,l,m,L,R,dis,leftPoint);
        if(R >  m) update(nowIndex<<1|1,m+1,r,L,R,dis,leftPoint);
        pushUp(nowIndex);
    }

    private static void pushUp(int nowIndex){
        segmentTree[nowIndex] = Math.min(segmentTree[nowIndex<<1], segmentTree[nowIndex<<1|1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        for(int i = 0;i<h;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int dis = 0;
            if(a == 1){
                dis = w+1;
            }else {
                dis = query(1, 1, w, a - 1, a - 1);
            }
            update(1, 1, w, a,b,dis+1,a);
            System.out.println(segmentTree[1] > w?-1:segmentTree[1]+i+1);
        }
    }
}
