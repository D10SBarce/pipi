import java.util.ArrayList;
import java.util.List;

public class TestDemo {
     class MyCircularDeque {
        private int [] elem;
        private int front;
        private int rear;
        private int size;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.elem = new int [k];

        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }
            this.elem[front] = value;
            this.front = this.front == 0 ? this.elem[elem.length-1] : this.front-1;
            if (isEmpty()){
                this.rear = (this.rear + 1) % elem.length;
            }
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }
            if(isEmpty()) {
                this.rear = (this.rear + 1) % elem.length;
            }
            this.elem[rear] = value;
            this.rear = this.rear == 0 ? this.elem[elem.length-1] : this.rear-1;
            size++;

            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()){
                return false;
            }
            this.front = (this.front+1) % elem.length;
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()){
                return false;
            }
            this.rear = this.rear == 0 ? this.elem[elem.length-1] : this.rear-1;
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()){
                return -1;
            }
            return this.elem[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {

                if (isEmpty()){
                    return -1;
                }
                return this.elem[rear];
            }


        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == this.elem.length;
        }
    }


    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    class Solution {
        public int getImportance(List<Employee> employees, int id) {
            for (Employee emp: employees) {
                if (emp.id == id){
                    int importance = emp.importance;
                    if(emp.subordinates != null && emp.subordinates.size() > 0){
                        for (int sub : emp.subordinates) {
                            importance += getImportance(employees,sub);
                        }
                    }
                    return importance;
                }
            }
            return 0;
       }
    }
    public class CatDogAsylum {
        public ArrayList<Integer> asylum(int[][] ope) {
            ArrayList<Integer> r = new ArrayList<Integer>();// 存放最终收养序列
            ArrayList<Integer> animal = new ArrayList<Integer>();// 存放进入收容所的动物
            int temp=0;
            for (int i = 0; i < ope.length; i++) {
                switch (ope[i][0]) {
                    // 有动物进入收容所
                    case 1:
                        animal.add(ope[i][1]);
                        break;
                    // 有人收养动物
                    case 2:
                        // 第一种收养方式
                        if (!animal.isEmpty()&&ope[i][1] == 0) {
                            r.add(animal.get(0));
                            animal.remove(0);
                        }
                        // 收养狗
                        else if (ope[i][1] == 1) {
                            for(temp=0;temp<animal.size();temp++){
                                if(animal.get(temp)>0){
                                    r.add(animal.get(temp));
                                    animal.remove(temp);
                                    break;
                                }
                            }
                        }
                        // 收养猫
                        else if(ope[i][1] == -1){
                            for(temp=0;temp<animal.size();temp++){
                                if(animal.get(temp)<0){
                                    r.add(animal.get(temp));
                                    animal.remove(temp);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
            return r;
        }
    }
}
