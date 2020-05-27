import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class Node{
    public  int data;//0
    public  Node next;//null
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList {
    public Node head;

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;

    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标

    private Node search(int index) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("位置不合法");
        }
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            if (count == index - 1) {
                return cur;
            }
        }
        return null;
    }

    public void addIndex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            addLast(data);
            return;
        }
        search(index);
        Node cur = new Node(index);
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;

    }

    //删除第一次出现关键字为key的节点
    private Node searchPrev(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            } else {
                prev = prev.next;
            }

        }
        return null;
    }

    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if (prev == null) {
            System.out.println("没有这个节点!");
            return;
        }
        Node del = prev.next;
        prev.next = del.next;
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node prve = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prve.next = cur.next;
                cur = cur.next;
            } else {
                prve = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }


    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;

        }

    }

    public void clear() {
        this.head = null;


    }
    //翻转单链表
    public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null){
            Node curNext = cur.next;
            if (curNext == null){
              newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void sss(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;

        }
    }
    //链表的中间结点
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node FindKthToTail(int k) {
        Node fast = this.head;
        Node slow = this.head;
        if (this.head == null) return null;
        if (k <= 0){
            System.out.println("K不合法！");
            return null;
        }
        while (k-1 > 0){
            if (fast.next != null){
                fast = fast.next;
                k--;
            }
            else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    public Node partition(int x) {
        Node cur = this.head;
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = cur;
                }
            }else {
                if (as == null) {
                     as = cur;
                     ae = cur;
                } else {
                     ae.next = cur;
                     ae = cur;
                }
            }
            cur = cur.next;
            }
        if (bs == null){
            return as;
        }else {
            be.next = as;
        }
        if(ae != null){
            ae.next = null;
        }
        return bs;

    }





    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node cur = this.head;
        Node tmp = newHead;
        while (cur != null){
            if(cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
            else{
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
                }
            }
        return newHead.next;
        }


    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast == null&&fast.next ==null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if (fast == null||fast.next ==null){
            return false;
        }
        return true;

    }
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast == null&&fast.next ==null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if (fast == null||fast.next ==null){
            return null;
        }
        slow = this.head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    private static int getSize(Node head){
        Node cur = head;
        int count = 0;
        while (head != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public static Node getIntersectionNode(Node headA, Node headB) {
        //1、求长度，走差值步
        Node pl = headA;
        Node ps = headB;
        int lenA = 0;
        int lenB = 0;
        while (pl!=null){
            lenA++;
            pl = pl.next;
        }
        while (ps != null){
            lenB++;
            ps = ps.next;
        }
        pl = headA;
        ps = headB;
        int len = lenA-lenB;
        if(len<0){
            pl = headB;
            ps = headA;
            len =lenB-lenA;
        }
        //一定是pl指向的是最长的单链表
        for (int i = 0;i<len;i++){
            pl = pl.next;
        }
        //ps和pl一定是在同一起跑线上
        while (ps!=pl&&pl!=null&&ps!=null){
            ps = ps.next;
            pl = pl.next;
        }
        if (pl == ps&&pl!=null){
            return pl;
        }
        return null;
    }
    public Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA !=null &&headB != null) {
            if (headA.data < headB.data) {
                tmp.next = headA;
                tmp = tmp.next;
                headA = headA.next;
            } else {
                tmp.next = headB;
                tmp = tmp.next;
                headB = headB.next;
            }
        }
        if (headA == null){
            tmp.next = headB;
         }
        if (headB == null){
            tmp.next = headA;
        }
        return newHead.next;

    }
}


