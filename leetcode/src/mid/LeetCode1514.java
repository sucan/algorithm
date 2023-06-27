package mid;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:32
 * @Description:
 */
public class LeetCode1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int vis[] = new int[n+1];
        double dist[] = new double[n+1];
        for(int i =0;i<n+1;i++){
            dist[i] = -1;
        }
        dist[start] = 1;
        for(;;){
            boolean updated = false;
            for(int i = 0;i<edges.length;i++){
                if(dist[edges[i][0]] != -1 && dist[edges[i][1]] < dist[edges[i][0]] * succProb[i]){
                    dist[edges[i][1]] = dist[edges[i][0]] * succProb[i];
                    updated = true;
                }
                if(dist[edges[i][1]] != -1 && dist[edges[i][0]] < dist[edges[i][1]] * succProb[i]){
                    dist[edges[i][0]] = dist[edges[i][1]] * succProb[i];
                    updated = true;
                }
            }
            if(!updated){
                break;
            }
        }
        if(dist[end] == -1){
            return 0;
        }else{
            return dist[end];
        }
    }
}
