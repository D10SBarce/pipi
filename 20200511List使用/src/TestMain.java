import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain {
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    private static List<Character> func(String str1, String str2){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length() ; i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")){
                list.add(ch);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<Character> list = func(str1,str2);
        System.out.println(list);
    }
}
