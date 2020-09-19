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
 * 上面的解法可以用set+mutilSet 来实现，还有另一种解法是用线段树来做，思路如下:
 *
 * 对于每一行我们维护一个数组w，w[i][j] 表示第i层到达j点时的最短路，则 min(w[i][j]) (w>= i >=1) 为答案，如果答案大于 W 则说明此行无法到达
 *
 * 同时我们知道如果 j < A[i-1] || j > B[i+1],那么w[i][j] = w[i-1][j],所以每一行需要更新的数据只有A[i-1] ~ B[i-1]区间内的数据
 *
 * 而A[i-1] ~ B[i-1] 的值为：w[i-1][A[i-1]-1] + 1,w[i-1][A[i-1]-1] + 2,w[i-1][A[i-1]-1] + 3,...... 为一个等差数列，最小值为w[i-1][A[i-1]-1] + 1
 *
 * 因此我们只需要记录下A[i-1]-1 和 w[i-1][A[i-1]-1] 的值，就可以用线段树进行区间更新了
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
            update(1, 1, w, a,b,dis,a-1);
            System.out.println(segmentTree[1] > w?-1:segmentTree[1]+i+1);
        }
    }
}
