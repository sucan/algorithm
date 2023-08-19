package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: kep
 * @Date: 2023/8/18 23:09
 * @Description:
 */
public class LeetCode068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while(index < words.length){
            int tmp = index;
            int characterCount = 0;
            int gap = 0;
            while(tmp < words.length && characterCount + words[tmp].length() + gap <= maxWidth){
                characterCount = characterCount + words[tmp].length() + gap;
                gap = 1;
                tmp++;
            }
            solve(maxWidth,words,index,tmp-1,ans,tmp == words.length);
            index = tmp;
        }
        return ans;
    }

    private void solve(int maxWidth,String[] words,int start,int end,List<String> ans,boolean isLast){
        if(isLast){
            ans.add(solveLast(maxWidth,words,start,end));
            return;
        }
        int wordCount = 0;
        for(int i = start;i<=end;i++){
            wordCount += words[i].length();
        }
        int spaceCount = (end-start) == 0?0:(maxWidth - wordCount)/(end-start);
        int appendIndex = (end-start) == 0?0:(maxWidth - wordCount)%(end-start);
        String space = "";
        for(int i = 0;i<spaceCount;i++){
            space +=" ";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start;i<=end;i++){
            sb.append(words[i]);
            if(i != end){
                sb.append(space);
                if(i - start < appendIndex){
                    sb.append(" ");
                }
            }
        }
        for(int i = sb.length();i<maxWidth;i++){
            sb.append(" ");
        }
        ans.add(sb.toString());
    }

    private String solveLast(int maxWidth,String[] words,int start,int end){
        StringBuilder sb = new StringBuilder();
        for(int i = start;i<=end;i++){
            if(sb.length() > 0){
                sb.append(" ");
            }
            sb.append(words[i]);
        }
        for(int i = sb.length();i<maxWidth;i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        new LeetCode068().fullJustify(words,16);
    }
}
