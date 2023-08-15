package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: kep
 * @Date: 2023/8/12 20:06
 * @Description:
 */
public class LeetCode295 {
    class MedianFinder {
        //大根
        PriorityQueue<Integer> left;
        //小根
        PriorityQueue<Integer> right;
        public MedianFinder() {
            left  = new PriorityQueue<Integer>(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return ((Integer)o2) - ((Integer)o1);
                }
            });
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            Integer leftPeek = left.isEmpty()?null:left.peek();
            Integer rightPeek = right.isEmpty()?null:right.peek();
            if(leftPeek == null){
                left.add(num);
            }else{
                if(num <= leftPeek){
                    left.add(num);
                }else{
                    right.add(num);
                }
                if(left.size() > right.size()){
                    right.add(left.poll());
                }else if(right.size() > left.size() +1){
                    left.add(right.poll());
                }
            }
        }

        public double findMedian() {
            if(left.size() == right.size()){
                if(left.size() == 0){
                    return 0;
                }
                return (left.peek() + right.peek())/2.0;
            }else{
                if(right.isEmpty()){
                    return left.peek();
                }
                return right.peek();
            }
        }
    }
}
