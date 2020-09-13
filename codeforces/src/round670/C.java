package round670;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by enpingkuang on 2020/9/12 10:32 下午
 */
public class C {

    private static Vector<Integer>[] G = new Vector[100005];
    private static int[] num = new int[100005]; //统计子树节点个数
    private static int centroid1,centroid2;

    private static void init(int n) {
        for (int i = 0; i <= n; i++) {
            if (G[i] == null) {
                G[i] = new Vector<Integer>();
            }
            G[i].clear();
            num[i] = 0;
        }
        centroid1 = centroid2 = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            init(n);
            for (int i = 0; i < n-1; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                add(a, b);
            }
            findCen(1,0,n);
            if(centroid2 == 0){
                System.out.println(1+" "+ G[1].get(0));
                System.out.println(1+" "+ G[1].get(0));
            }else{
                for(int i = 0;i<G[centroid1].size();i++){
                    if(G[centroid1].get(i) != centroid2){
                        System.out.println(centroid1+" "+G[centroid1].get(i));
                        System.out.println(centroid2+" "+G[centroid1].get(i));
                        break;
                    }
                }
            }
        }
    }

    private static void add(int a, int b) {
        G[a].add(b);
        G[b].add(a);
    }

    /**
     * 查找重心
     * @param v
     * @param p
     * @param n
     */
    private static void findCen(int v,int p,int n) {
        int subTree_nodeCount = 1,max_subTree_nodeCount=0;
        for(int i=0;i<G[v].size();i++) {
            int w = G[v].get(i);
            if(w == p)continue;
            findCen(w,v,n);
            subTree_nodeCount += num[w];
            max_subTree_nodeCount = Math.max(max_subTree_nodeCount,num[w]);
        }
        num[v] = subTree_nodeCount;
        if(max_subTree_nodeCount * 2 <= n && (n - num[v]) * 2 <= n){
            if(centroid1 == 0) {
                centroid1 = v;
            }else {
                centroid2 = v;
            }
        }
    }


}
