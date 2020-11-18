package 面试题;

/**
 * @Author: liulei
 * @Date: 2020/11/18 16:28
 * @Description:
 */
public class Solution {
    public Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            //修改逆置关系
            cur.next = prev;

            //在此之上， prev就是cur的前驱结点
            prev = cur;   // prev = x;
            cur = next; // 这个时候，next是cur.next的原来的值

        }
        return prev;

    }
    private int size(Node head){
        int size = 0;
        Node cur = head;
        while (cur != null){
            cur = cur.next;
            size++;
        }
        return size;
    }

    public boolean 回文(Node head){
        int size = size(head);
        int half = size/2;

        Node node = head;
        for (int i = 0; i < half; i++) {
            node = node.next;
        }
        Node reverseHead = reverse(node);
        Node c1 = head;
        Node c2 = reverseHead;
        while (c1 != null && c2 != null){
            if (c1.val != c2.val){
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }
    public Node 合并两个有序链表(Node h1, Node h2) {
        // 0. 前提是，两个线性表都还有元素
        // 1. 从两个线性表中依次取出元素进行比较（头删）
        // 2. 将小的放入结果线性表中（尾插）

        Node ansHead = new Node(-1);
        Node last = ansHead;

        Node c1 = h1;
        Node c2 = h2;

        while (c1 != null && c2 != null) {
            Node node;
            if (c1.val <= c2.val) {
                node = c1;
                c1 = c1.next;
            } else {
                node = c2;
                c2 = c2.next;
            }

            // node 是被头删出来的结点
            // 接着把 node 尾插到结果链表中
            last.next = node;
            last = node;
        }

        if (c1 != null) {
            last.next = c1;
        } else {
            last.next = c2;
        }

        return ansHead.next;
    }
}
