package mid;

/**
 * @Auther: kep
 * @Date: 2022/4/22 21:07
 * @Description:
 */
public class LeetCode058 {

    class Point{

        private int x;
        private int y;
        private int[][] result;
        private int n;
        private int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        private int flag = 0;
        public Point(int n,int[][] result){
            x = y = 0;
            this.n = n;
            this.result = result;
        }


        public void assignment(int v){
            result[x][y] = v;
        }
        public void next(){
            int tmpX = x + dir[flag][0];
            int tmpY = y + dir[flag][1];
            if(tmpX < 0|| tmpX >= n || tmpY < 0 || tmpY >=n || result[tmpX][tmpY] != 0){
                flag = (flag + 1)%4;
            }
            x += dir[flag][0];
            y += dir[flag][1];
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        Point point = new Point(n,result);
        point.x = 0;
        point.y = 0;
        for(int i = 1;i<=n*n;i++){
            point.assignment(i);
            point.next();
        }
        return result;
    }
}
