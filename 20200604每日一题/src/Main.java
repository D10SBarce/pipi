import java.util.Scanner;

public class Main {
    public static void MaxString(String str){
        int count = 0;
        String s2 = "";
        char [] arr = str.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            if ('0' <= arr[i] && '9' >= arr[i]){
                count = 1;
                int index = i;
                for (int j = i+1; j < arr.length; j++) {
                    if ('0' <= arr[j]  && '9' >= arr[j]){
                        count++;
                        index = j;
                    }else {
                        break;
                    }
                }
                if (count > s2.length()){
                    s2 = str.substring(i,index+1);
                }

            }
            else {
                continue;
            }
        }
        System.out.println(s2);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();

        MaxString(s1);

    }
}
