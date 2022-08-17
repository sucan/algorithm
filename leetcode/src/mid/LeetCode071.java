package mid;

import java.util.*;

/**
 * @Auther: kep
 * @Date: 2022/4/25 22:57
 * @Description:
 */
public class LeetCode071 {
    public String simplifyPath(String path) {
        int length = path.length();
        LinkedList<String> paths = new LinkedList<>();
        String tmp = "";
        for(int i =0;i<length;){
            if(path.charAt(i) == '/'){
                if(!tmp.equals("")) {
                    if(tmp.equals("..")){
                        if(!paths.isEmpty()){
                            paths.removeLast();
                        }
                    }else if(tmp.equals(".")){

                    }else {
                        paths.add(tmp);
                    }
                }
                while(i < length && path.charAt(i) == '/'){
                    i++;
                }
                tmp = "";
            }else{
                tmp += path.charAt(i);
                i++;
            }
        }
        if(!tmp.equals("")) {
            if(tmp.equals("..")){
                if(!paths.isEmpty()){
                    paths.removeLast();
                }
            }else if(tmp.equals(".")){

            }else {
                paths.add(tmp);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(String.join("/",paths));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new LeetCode071().simplifyPath("/a/./b/../../c/");
    }
}
