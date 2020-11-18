package ll;

/**
 * @Author: liulei
 * @Date: 2020/11/18 14:55
 * @Description:
 */
public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;
    //o(1)时间复杂度
    public boolean add(String e){
        //把元素装到结点对象中
        Node node = new Node(e);
        //连表为空的情况
        if (head == null){
            head = last = node;
            size++;
        }else {
            //链表不为空
            node.prev = last;
            last.next = node;
            last = node;
            size++;
        }
        return true;
    }
    public void add(int index,String e){
        checkIndex(index);
        Node node = new Node(e);
        if (head == null){
            //index一定是0
            head = last = node;
        }else if (index == 0){
            node.next = head;
            head.prev = node;
            head = node;
            size++;
        }else if(index == size()){
            add(e);
        }else {
            Node prev = getPreviousByIndex(index);
            Node next = prev.next;
            node.prev = prev;
            node.next = next;
            next.prev = node;
            size++;
        }
    }

    private Node getPreviousByIndex(int index) {
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            //找到要操作的位置
            prev = prev.next;
        }
        return prev;
    }

    public String remove(int index){
        checkIndex(index);
        String v = null;
        if (size() == 1){
            head = last = null;
            v = head.val;
        }else if (index == 0){
            head = head.next;
            head.prev = null;
            v = head.val;

        }else if (index ==size() -1){
            last = last.prev;
            last.next = null;
            v = last.val;
        }else {
            Node node = getPreviousByIndex(index);
            Node a = node.prev;
            Node b = node.next;
            a.next = b;
            b.prev = a;
            v =  node.val;
        }
        return v;
    }
    public boolean remove(String e){
        Node current = head;
        while (current != null){
            if (current.val.equals(e)){
                Node prev = current.prev;
                Node next = current.next;
                if (prev != null){
                prev.next = next;
                }else {
                    head = head.next;
                }if (next != null) {
                    prev.prev = prev;
                }else {
                    last = last.prev;
                }
                size--;
                return true;

            }
            current = current.next;
        }
        return false;
    }
    public String get(int index){
        checkIndex(index);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            //找到要操作的位置
            prev = prev.next;
        }
        return prev.val;

    }
    public String set(int index,String e){
        checkIndex(index);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            //找到要操作的位置
            prev = prev.next;
        }
        String oldval = prev.val;
        prev.val = e;
        return oldval;
    }
    public boolean contains(String e){
        return indexOf(e) != -1;
    }

    private int indexOf(String e) {
        Node node = head;
        for (int i = 0; i < size(); i++) {
            if (node.val.equals(e)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }
    public int lastIndexOf(String e){
        Node node = last;
        for (int i = size()-1; i >= 0 ; i--) {
            if (node.val.equals(e)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("下标越界" + index);
        }
    }

    public int size(){
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            size++;
        }
        return size;
    }
}
