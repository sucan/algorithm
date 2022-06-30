import java.util.ArrayList;
import java.util.List;

/**
 * 格雷码
 * 如果直接思考怎么构造n阶格雷码的话就会有点困难，所以需要换个思路思考一下怎么由n阶格雷码生成n+1阶格雷码，然后一层一层构造就会简单一点
 * n阶的取值范围是[0,2^n -1] n+1阶的取值范围是[0,2^(n+1) - 1],新增的数刚好是n阶的一倍，用二进阶表示刚好就是n阶的所有数加一个前导1，并且天然也是一个格雷码
 * 因此从n阶到n+1阶只需要把新增的部分按照倒序添加至n阶的末尾即可
 * @Auther: kep
 * @Date: 2022/4/30 17:13
 * @Description:
 */
public class LeetCode089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        for(int i = 1;i<n;i++){
            List<Integer> subArray = new ArrayList<>();
            for(int j = result.size()-1;j>=0;j--){
                subArray.add(result.get(j) | (1<<i));
            }
            result.addAll(subArray);
        }
        return result;
    }
}
