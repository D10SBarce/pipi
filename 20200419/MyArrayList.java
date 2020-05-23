
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-04-19
 * Time: 15:29
 */
import java.util.Arrays;

public class MyArrayList {

    public int[] elem;//数组
    public int usedSize;//有效的数据个数
    public static final int intCapacity = 10;//初始容量

    public MyArrayList() {
        this.elem = new int[intCapacity];
        this.usedSize = 0;
    }

    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(this.elem[i] + "");
        }
        System.out.println();
    }

    private boolean isFull() {
     /*   if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;*/
        return this.usedSize == this.elem.length;
    }


    private void checkPos(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            throw new RuntimeException("pos位置不合法!");
        }
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        checkPos(pos);

        if (isFull()) {
            this.elem =
                    Arrays.copyOf(this.elem, 2 * this.elem.length);
        }

        //挪数据了
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind){
        for(int i=0;i<=this.usedSize;i++){
            if (this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int seach(int toFind){
        for(int i=0;i<=this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos){
        if(isEmpty()){
            throw new RuntimeException("顺序表为空");//手动抛出异常
        }
        if(pos<0||pos>=this.usedSize){
            throw new RuntimeException("顺序表为空");//手动抛出异常
        }
        return this.elem[pos];
    }
    // 获取顺序表长度
    public int size(){
        return this.elem.length;
    }
    //删除第一次出现的关键字toRemove
    public void remove(int toRemove){
        int index=seach(toRemove);
        if(index==-1){
            System.out.println("找到不需要删除的数字！");
            return;
        }
        for (int i=index;i<this.usedSize-1;i++){
            this.elem[i]=this.elem[i+1];
        }
        this.usedSize--;
    }
    // 清空顺序表
    public void clear(){
        this.usedSize = 0;
    }
    //更新pos位置的元素
    public void setPos(int pos, int value){
        if(pos<0||pos>=this.usedSize){
            throw new RuntimeException("pos位置不合法！");
        }
        this.elem[pos] = value;


    }
}




