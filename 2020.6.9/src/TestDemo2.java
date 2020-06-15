import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * @program: 2020.6.9
 * @description:
 * @author: spdz
 * @create: 2020-06-14 20:32
 **/
public class TestDemo2 {

    // public int compare(int o1, int o2) {
    //     return o1-o2;
    // }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2) {
                return o2 - o1;
            }
        });

        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->compare(o2,o1));

        for(int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }
        while(!maxHeap.isEmpty()) {
            if(maxHeap.size() == 1) {
                return maxHeap.poll();
            }else {
                int x = maxHeap.poll();
                int y = maxHeap.poll();
                if(x > y) {
                    maxHeap.offer(x-y);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array1 = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(array1));//1

        int[] array2 = {2,7,4,1,8,1,1};
        System.out.println(lastStoneWeight(array2));//0

        int[] array3 = {7};
        System.out.println(lastStoneWeight(array3));//7
    }
}
