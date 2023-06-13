package string;

import java.util.stream.Stream;

/**
 * @Auther: kep
 * @Date: 2023/6/14 00:02
 * @Description:
 */
public class KMP {

    private void initNext(int[] next,String patten){
        next[0] = -1;
        next[1] = 0;
        int j = 0;
        for(int i = 2;i<patten.length();i++){
            while(j != 0 && patten.charAt(i) != patten.charAt(j)){
                j = next[i];
            }
            if(patten.charAt(j) == patten.charAt(i)){
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        int[] next= new  int[10];
        new KMP().initNext(next,"aazsaadszv");
        for(int i = 0;i<10;i++){
            System.out.print(next[i]);
        }
        Stream.of(next).forEach(System.out::print);
    }
}
