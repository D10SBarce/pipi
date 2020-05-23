import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-19
 * Time: 14:28
 */
class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return this.num1 + this.num2;
    }
    public int  sub() {
        return this.num1 - this.num2;
    }
    public int mul() {
        return this.num1 * this.num2;
    }
    public double dev() {
        return this.num1*1.0/this.num2;
    }

}

class MyValue {
    private int val;

    //private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

public class TestDemo {

   /* public static void swap(MyValue myVal1,MyValue myVal2) {
        int tmp = myVal1.val;
        myVal1.val = myVal2.val;
        myVal2.val = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println(myValue1.val);//10
        System.out.println(myValue2.val);//20
        System.out.println("开始交换：");
        swap(myValue1,myValue2);
        System.out.println(myValue1.val);
        System.out.println(myValue2.val);

    }*/

    public static void swap(MyValue myValue1,MyValue myValue2) {
        int tmp = myValue1.getVal();
        myValue1.setVal(myValue2.getVal());
        myValue2.setVal(tmp);
    }

    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.setVal(10);

        MyValue myValue2 = new MyValue();
        myValue2.setVal(20);

        System.out.println(myValue1.getVal());
        System.out.println(myValue2.getVal());
        System.out.println("开始交换：");
        swap(myValue1,myValue2);

        System.out.println(myValue1.getVal());
        System.out.println(myValue2.getVal());

    }

    public static void main2(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(20);
        System.out.println("加法");
        System.out.println(calculator.add());
        System.out.println("减法");
        System.out.println(calculator.sub());
    }

    public static void func(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            int tmp = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp;
        }
    }
    public static void main1(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {91,81,71,61,51,41};
        func(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
