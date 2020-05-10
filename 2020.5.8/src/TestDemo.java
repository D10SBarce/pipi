import java.util.Scanner;

/**
 * @program: 2020.5.8
 * @description:
 * @author: spdz
 * @create: 2020-05-08 20:17
 **/
public class TestDemo {


    public static String reverse(String str,int begin,int end) {
        char[] value = str.toCharArray();
        while (begin < end) {
            char tmp = value[begin];
            value[begin] = value[end];
            value[end] = tmp;
            begin++;
            end--;
        }
        //return new String(value);
        return String.copyValueOf(value);
    }

    public static String func(int n,String str) {
        if (str == null || n < 0 || n >= str.length()) {
            return null;
        }
         str = reverse(str,0,n-1);
         str = reverse(str,n,str.length()-1);
         str = reverse(str,0,str.length()-1);
         return str;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        String ret = func(n,str);
        System.out.println(ret);
    }
}
