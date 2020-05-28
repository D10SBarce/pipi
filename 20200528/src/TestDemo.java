import java.util.HashSet;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-05-28
 * Time: 17:26
 */
public class TestDemo {

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] array = {7,2,9,18,56,15,3};
        for (int i : array) {
            bsTree.insert(i);
        }
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();
        System.out.println(bsTree.search(18).val);
        System.out.println("==========删除============");
        bsTree.remove(18);
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();

    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();//7_This_is_a_test
        String actual = scanner.nextLine();//_hs_s_a_es

        //1、把实际的字符转换为大写存放到集合当中
        HashSet<Character> setActual = new HashSet<>();
        for (char s : actual.toUpperCase().toCharArray()) {
            setActual.add(s);
        }
        HashSet<Character> setBroken = new HashSet<>();
        for (char ex :expected.toUpperCase().toCharArray()) {
            if(!setActual.contains(ex) && !setBroken.contains(ex)) {
                System.out.print(ex);
                setBroken.add(ex);
            }
        }
    }
}
