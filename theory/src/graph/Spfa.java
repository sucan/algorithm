package graph;

/**
 * @Auther: kep
 * @Date: 2023/8/6 17:47
 * @Description:
 */
public class Spfa {
//    vector<node>mp[maxn];//用vector建立邻接表
//    void Spfa(int s) {
//        queue<int>v;
//        vis[s] = 1; v.push(s); dis[s] = 0;
//        while (!v.empty()) {
//            int q = v.front();
//            v.pop(); vis[q] = 0;
//            for (int i = 0; i < mp[q].size(); i++) {
//                if (dis[mp[q][i].s1] > dis[q] + mp[q][i].side) {
//                    dis[mp[q][i].s1] = dis[q] + mp[q][i].side;//更新最短路径。
//                    if (!vis[mp[q][i].s1]) {//是在更新新的值条件里面判断，一定特别注意这点
//                        v.push(mp[q][i].s1);
//                        vis[mp[q][i].s1] = 1;//标记未标记过的点
//                    }
//                }
//            }
//        }
//    }
}
