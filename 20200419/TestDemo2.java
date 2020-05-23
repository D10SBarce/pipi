/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-19
 * Time: 15:17
 */



public class TestDemo2 {
    public static void main(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();
        for(int i=0;i<10;i++){
            myArrayList1.add(i,i);
        }myArrayList1.display();
        myArrayList1.add(4,199);
        myArrayList1.display();
        System.out.println(myArrayList1.seach(199));
        System.out.println(myArrayList1.getPos(6));
        System.out.println(myArrayList1.size());
        myArrayList1.remove(199);
        myArrayList1.display();
        System.out.println(myArrayList1.contains(1));
        myArrayList1.setPos(7,52);
        myArrayList1.display();
       /* myArrayList1.clear();
        myArrayList1.display()*/;
        /*myArrayList1.remove(4);
        myArrayList1.display();
        System.out.println("clear()");
        myArrayList1.clear();
        myArrayList1.display();*/

        /*System.out.println(myArrayList1.getPos(4));
        myArrayList1.display();*/

      /*  System.out.println("==================");
        System.out.println(myArrayList1.search(51));
        System.out.println(myArrayList1.contains(15));*/

    }
}
