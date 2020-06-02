import java.util.Scanner;
public class Main {
    private static boolean isHuiWen(String str1){
        int a = 0;
        int b = str1.length()-1;
        while (a < b){
            if (str1.charAt(a) != str1.charAt(b)){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            StringBuffer sb = new StringBuffer(str1);
            sb.insert(i,str2);
            if (isHuiWen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);

    }
}
