package mid;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2023/8/6 17:44
 * @Description:
 */
public class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer> hashMap = new HashMap<>();
        int index = 0;
        for(List<String> strings:equations){
            for(String str:strings){
                if(hashMap.containsKey(str)){
                    continue;
                }
                index++;
                hashMap.put(str,index);
            }
        }
        double[][] dis = new double[index+1][index+1];
        for(int i = 0;i<dis.length;i++){
            for(int j = 0;j<dis[0].length;j++){
                dis[i][j] = Double.MAX_VALUE;
            }
        }
        for(int i = 0;i<equations.size();i++){
            List<String> strings = equations.get(i);
            String a = strings.get(0);
            String b = strings.get(1);
            dis[hashMap.get(a)][hashMap.get(b)] = values[i];
            dis[hashMap.get(b)][hashMap.get(a)] = 1/values[i];
        }
        for(int k = 0;k<=index;k++){
            for(int i = 0;i<dis.length;i++){
                for(int j = 0;j<dis.length;j++){
                    if(dis[i][j] == Double.MAX_VALUE && dis[i][k] != Double.MAX_VALUE &&  dis[k][j]!=Double.MAX_VALUE){
                        dis[i][j] = dis[i][k] * dis[k][j];
                    }
                }
            }
        }
        double[] ans = new double[queries.size()];
        for(int i = 0;i<queries.size();i++){
            Integer a = hashMap.get(queries.get(i).get(0));
            Integer b = hashMap.get(queries.get(i).get(1));
            if(a == null || b == null || dis[a][b] == Double.MAX_VALUE){
                ans[i] = -1;
            }else{
                ans[i] = dis[a][b];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<List<String>>(){{
            add(new ArrayList<String>(){{
                add("a");
                add("b");
            }});
            add(new ArrayList<String>(){{
                add("b");
                add("c");
            }});
        }};
        double[] values = {2.0,3.0};
        //["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]
        List<List<String>> queries = new ArrayList<List<String>>(){{
            add(new ArrayList<String>(){{
                add("a");
                add("c");
            }});
            add(new ArrayList<String>(){{
                add("b");
                add("a");
            }});
            add(new ArrayList<String>(){{
                add("a");
                add("e");
            }});
            add(new ArrayList<String>(){{
                add("a");
                add("a");
            }});
            add(new ArrayList<String>(){{
                add("x");
                add("x");
            }});
        }};
        new LeetCode399().calcEquation(equations,values,queries);
    }
}
