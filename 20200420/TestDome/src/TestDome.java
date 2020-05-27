public class TestDome {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(7);
        myLinkedList.addFirst(1);
        myLinkedList.display();
        System.out.println("______________");
        myLinkedList.deleteDuplication();
        myLinkedList.display();


    }



}
