package abc179;

import java.util.*;

/**
 * Created by enpingkuang on 2020/9/22 12:12 上午
 */
public class F {


    static class Node{
        int type;
        long value;
        Node(int type,long value){
            this.value = value;
            this.type = type;
        }
    }

    private static final int MAX_N = 200005;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int q = scanner.nextInt();
        Set<Long> oneSet = new TreeSet<>();
        Set<Long> twoSet = new TreeSet<>();
        oneSet.add(n);
        twoSet.add(n);
        List<Node> list = new ArrayList<>();
        for(int i = 0;i<q;i++){
            int type = scanner.nextInt();
            long value = scanner.nextLong();
            list.add(new Node(type,value));
            if(type == 1){
                oneSet.add(value);
            }else{
                twoSet.add(value);
            }
        }
        long h = n,w = n;
        long ans = 0;
        long max_h = MAX_N;
        long max_w = MAX_N;
        List<Long> oneList = new ArrayList<>(oneSet);
        List<Long> twoList = new ArrayList<>(twoSet);
        for(Node node:list){
            if(h <=2 || w <= 2){
                break;
            }
            if(node.type == 1 && node.value< max_w){
                max_w = node.value;
                long size = oneList.size();
                int index = find(oneList,node.value);
                oneList = oneList.subList(0,index+1);
                long count = (w - node.value ) - (size - oneList.size());
                ans = ans + count*(h-2);
                w = node.value;
            }
            if(node.type == 2 && node.value < max_h){
                max_h = node.value;
                long size = twoList.size();
                int index = find(twoList,node.value);
                twoList = twoList.subList(0,index+1);
                long count = (h - node.value) - (size - twoList.size());
                ans = ans + count*(w-2);
                h = node.value;
            }
        }
        if(!(h <=2 || w <= 2)){
            ans = ans + (h-2) * (w-2);
        }
        System.out.println(ans);
    }

    private static int find(List<Long> list,long value){
        int left = 0,right = list.size();
        while(left < right){
            int mid = (right + left)/2;
            if(list.get(mid) == value){
                return mid;
            }else if(list.get(mid) > value){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

}
