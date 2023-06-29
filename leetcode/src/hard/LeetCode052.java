package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/6/29 01:40
 * @Description:
 */
public class LeetCode052 {
    private int ans = 0;
    public int totalNQueens(int n) {
        ans = 0;
        boolean[] col = new boolean[n];
        boolean[] row = new boolean[n];
        dfs(0,n,col,row,new ArrayList<>());
        return ans;
    }

    private void dfs(int deep,int n,boolean[] col,boolean[] row,List<String> tmp){
        if(deep == n){
            ans++;
            return;
        }
        char[] chars = new char[n];
        for(int i = 0;i<n;i++){
            chars[i] = '.';
        }

        for(int i = 0;i<n;i++){
            if(!col[deep] && !row[i] && check(deep,i,n,tmp)){
                col[deep] = true;
                row[i] = true;
                chars[i] = 'Q';
                tmp.add(new String(chars));
                dfs(deep+1,n,col,row,tmp);
                col[deep] = false;
                row[i] = false;
                chars[i] = '.';
                tmp.remove(deep);
            }
        }
    }

    private boolean check(int i,int j,int n,List<String> map){
        int tmpX = i,tmpY = j;
        tmpX--;
        tmpY--;
        while(tmpX >=0 && tmpY>=0 && tmpY < n){
            String s = map.get(tmpX);
            if(s.charAt(tmpY) == 'Q'){
                return false;
            }
            tmpX--;
            tmpY--;
        }
        tmpX = i;
        tmpY = j;
        tmpX--;
        tmpY++;
        while(tmpX >=0 && tmpY>=0 && tmpY < n){
            String s = map.get(tmpX);
            if(s.charAt(tmpY) == 'Q'){
                return false;
            }
            tmpX--;
            tmpY++;
        }
        return true;
    }
}
