import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-05-26
 * Time: 19:52
 */
public class TestDemo5 {

    public int singleNumber(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            }else {
                hashSet.add(nums[i]);
            }
        }
        Iterator<Integer> it = hashSet.iterator();
        return it.next();
    }


    /**
     * 3、10万个数据，统计重复数字及出现的次数
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //key --> 关键字重复的数字          5
        //value--> 重复的数字出现的次数     7
        for (Integer key : list) {
            if(map.get(key) == null) {
                map.put(key,1);
            }else {
                Integer val = map.get(key);
                map.put(key,val+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"这个数字出现了"+entry.getValue()+"次！");
        }
    }

    /**
     * 2、大数据去重问题：
     * 10W个数据当中 有重复元素，请去掉重复的元素。
     * @param args
     */
    public static void main4(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer val : list) {
            set.add(val);
        }
        System.out.println(set);
    }


    /**
     * 1、找出10W个数据当中，第一个重复的元素。
     * @param args
     */
    public static void main3(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(6));
        }
        System.out.println(list);

        HashSet<Integer> set = new HashSet<>();
        for (Integer val :list) {
            if(set.contains(val)) {
                System.out.println("找到了第一个重复的元素：" + val);
                return;
            }else {
                set.add(val);
            }
        }
    }


    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(31);
        set.add(2);
        System.out.println(set);
        Iterator<Integer> it = set.iterator();//迭代器
        while (it.hasNext()) {
            System.out.println(it.next());
            //打印it的下一个，并且it向后走一步
        }
    }

    public static void main1(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("mengde","caocao");
        map.put("xiaozhang","zhangfei");
        map.put("xiaoguan","guanyu");

        for( Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" -> " + entry.getValue());
        }
    }
}
