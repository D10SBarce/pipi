import java.util.*;

/**
 * @program: 2020.6.9
 * @description:
 * @author: spdz
 * @create: 2020-06-14 14:37
 **/
public class TestDemo {

    //和最小的 K 对数字
    public static int compare2(int[] o1, int[] o2) {
        return (o1[0] + o1[1]) - (o2[0] + o2[1]);
    }

    public static List<List<Integer>> kSmallestPairs(int[] array1, int[] array2, int k){
//        //匿名内部类
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
//
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return compare2(o2,o1);
//            }
//        });

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1,o2) -> compare2(o2,o1));

        for (int i :array1) {
            for (int j :array2) {
                int[] arr = {i,j};
                if (maxHeap.size() < k) {
                    maxHeap.offer(arr);
                }else {
                    if (!maxHeap.isEmpty() && compare2(maxHeap.peek(), arr) > 0) {
                        maxHeap.poll();
                        maxHeap.offer(arr);
                    }
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int[] tmp = maxHeap.poll();
            //ret.add(Arrays.asList(tmp[0], tmp[1]));//数组 转 列表
            list.add(tmp[0]);
            list.add(tmp[1]);
            ret.add(0,list);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array1 = {1,7,11};
        int[] array2 = {2,4,6};
        System.out.println(kSmallestPairs(array1,array2,3));
    }
}
