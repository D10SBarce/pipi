class Node{
    public  int data;
    public  Node next;
    public  Node prev;

    public Node(int data){
        this.data = data;
    }
}

public class MyLinkedList {
    public Node head;
    public Node tail;
    //头插法
    public void addFirst(int data){
        //是否是第一次插入
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;

    }
    //任意位置插入,第一个数据节点为0号下标
    private void  checkIndex(int index) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("位置不合法");
        }

    }
    private Node seachIndex(int index){
        Node cur = this.head;
        while (index-1!=0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    public void addIndex(int index,int data){
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
        }
        if (index == this.size()) {
            addLast(data);
        }else {
            Node cur = seachIndex(index);
            Node node = new Node(data);
            node.next = cur;
            node.prev = cur.next;
            cur.prev.next = node;
            cur.prev = node;

        }
    }
     //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
     //删除第一次出现关键字为key的节点
    public int  remove(int key){
        Node cur = this.head;
        while (cur!=null){
            if (cur.data == key){
                int oldData = cur.data;
                if (cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }
                else{
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    }
                    else {
                        this.tail = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }
    //删除所有值为key的节点
      public void removeAllKey(int key){
          Node cur = this.head;
          while (cur!=null){
              if (cur.data == key){
                  int oldData = cur.data;
                  if (cur == this.head){
                      this.head = this.head.next;
                      if (this.head != null) {
                          this.head.prev = null;
                      }
                  }
                  else{
                      cur.prev.next = cur.next;
                      if (cur.next != null){
                          cur.next.prev = cur.prev;
                      }
                      else {
                          this.tail = cur.prev;
                      }
                  }

              }
              cur = cur.next;
          }
      }
    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        return len;

    }
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.println(cur.data + "");
            cur = cur.next;
        }

    }
    public void clear(){
        Node cur = this.head.next;
        if (this.head != null){
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;
        }
        this.tail = null;
    }
}
