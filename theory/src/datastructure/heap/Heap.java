package datastructure.heap;

/**
 * 堆是满足如下性质的二叉树：
 *
 * 1. 任意非根节点一定大于等于或者小于等于父节点
 *
 * 本类为小根堆实现
 * Created by enpingkuang on 2020/8/16 3:26 PM
 */
public class Heap {
    private static int[] heap = new int[100000];
    private static int index = 0;

    /**
     * 插入到数组末尾，然后不停向上回溯
     *
     * value >= 0
     *
     */
    private static void push(int value){
        int i = index++;
        while(i >0){
            int  p = (i-1)/2;
            if(heap[p] <= value){
                break;
            }
            heap[i] = heap[p];
            i = p;
        }
        heap[i] = value;
    }

    private static int pop(){
        int result = heap[0];
        int value = heap[--index];
        int i = 0;
        while(i*2 + 1 < index){
            int lIndex =i*2 + 1;
            int rightIndex = i*2 + 2;
            if(rightIndex < index && heap[rightIndex] < heap[lIndex]){
                lIndex = rightIndex;
            }
            if(heap[lIndex] >= value){
                break;
            }
            heap[i] = heap[lIndex];
            i = lIndex;
        }
        heap[i] = value;
        return result;
    }

    public static void main(String[] args){

    }
}
