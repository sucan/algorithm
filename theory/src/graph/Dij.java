package graph;

/**
 * @Auther: kep
 * @Date: 2023/8/6 18:11
 * @Description:
 */
public class Dij {
//    int dijkstra(int n, int m) {//n为顶点数，m为起点开始的位置
//        while (true) {
//            fill(dis, dis + maxn, INF);
//            dis[m] = 0;//初始化起点为0
//            int index = -1;
//            int minx = 0;//定义
//            for (int i = 1; i <= n; i++) {
//                if (!vis[i] && minx > dis[i]) {//寻找到该点
//                    index = i;
//                    minx = dis[i];
//                }
//            }
//            if (index == -1) {//说明没有点可以继续搜索了
//                break;//退出循环条件
//            }
//            vis[index] = 1;//已经确定该点为最短路径点了，标记上踢出
//            for (int j = 1; j <= n; j++) {
//                if (dis[j] > dis[index] + mp[index][j]&&vis[j]==0&&mp[index][j]!=INF) {//该点有路可以走
//                    dis[j] = dis[index] + mp[index][j];//值得思考有DP思想
//                }
//            }
//        }
}
