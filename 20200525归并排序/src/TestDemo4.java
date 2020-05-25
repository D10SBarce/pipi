import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-05-25
 * Time: 20:38
 */
class Animal {
    public void func(){
        System.out.println("Animal::func()");
    }
}
public class TestDemo4 {
    public static void main(String[] args) {
        new Animal(){
            @Override
            public void func() {
                System.out.println("我重写了这个方法！");
            }
        }.func();
    }
}
