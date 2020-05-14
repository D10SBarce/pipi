import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue1.isEmpty()){
            queue1.offer(x);
        }else if(!queue2.isEmpty()){
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        int qSize1 = queue1.size();
        int qSize2 = queue2.size();
        int data = 0;
        if(!queue1.isEmpty()) {// 0- 5-1
            for (int i = 0; i < qSize1 - 1; i++) {
                queue2.offer(queue1.poll());
            }
            data = queue1.poll();
        }else {
            for (int i = 0; i < qSize2 - 1; i++) {
                queue1.offer(queue2.poll());
            }
            data = queue2.poll();
        }
        return data;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) {
            return -1;
        }
        int qSize1 = queue1.size();
        int qSize2 = queue2.size();
        int data = 0;
        if(!queue1.isEmpty()) {// 0- 5-1
            for (int i = 0; i < qSize1; i++) {
                data = queue1.poll();
                queue2.offer(data);
            }
        }else {
            for (int i = 0; i < qSize2; i++) {
                data = queue2.poll();
                queue1.offer(data);
            }
        }
        return data;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}

