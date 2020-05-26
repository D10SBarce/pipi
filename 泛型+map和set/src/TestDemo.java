/**
 * Created with IntelliJ IDEA.
 * Description:
 * 实例内部类
 * 静态内部类
 * 匿名内部类
 * User: GAOBO
 * Date: 2020-05-26
 * Time: 16:40
 */
/*class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;
    private int data4 = 4;

    class InnerClass {
        public int data3 = 3;
        public int data1 = 10;

        public void func() {
            System.out.println(data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(OuterClass.this.data1);
            System.out.println(data4);
        }
    }
}*/
class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;
    private int data4 = 4;

    /**
     * 静态内部类当中 不能访问外部类的非静态的数据成员
     *
     * 我非要进行访问怎么办？
     *
     */
    static class InnerClass {
        public int data3 = 3;
        public OuterClass out ;
        public InnerClass(OuterClass out) {
            this.out = out;
        }

        public void func() {
            System.out.println(this.out.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(this.out.data4);
        }
    }
}
public class TestDemo {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass(outerClass);
        innerClass.func();
    }

   /* public static void main1(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.func();
    }*/
}
