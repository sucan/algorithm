package hard;

/**
 * @Auther: kep
 * @Date: 2023/6/28 01:31
 * @Description:
 */
public class LeetCode1515 {
    public double getMinDistSum(int[][] positions) {
        double t = 50;
        double x = 50, y = 50;
        double ans = -1;
        while (t >= 10e-4) {
            double minx = 0,miny=0;
            for (double tx = x - t; tx <= x + t; tx += t / 100) {
                for (double ty = y - t; ty <= y + t; ty += t / 100) {
                    double tmp = getSum(positions, tx, ty);
                    if (ans == -1 || tmp < ans) {
                        ans = tmp;
                        minx = tx;
                        miny = ty;
                    }
                }
            }
            x = minx;
            y = miny;
            t /=100;
        }
        return ans;
    }

    public double getSum(int[][] positions,double x,double y){
        double ans = 0;

        for(int[] p: positions){
            double d = Math.pow(p[0]-x,2) + Math.pow(p[1]-y,2);
            ans += Math.sqrt(d);
        }

        return ans;
    }
}
