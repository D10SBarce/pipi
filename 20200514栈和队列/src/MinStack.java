import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x){
        stack.push(x);
        if (minStack.empty()){
            minStack.push(x);
        }else {
            int top = minStack.peek();
            if (top <= x){
                minStack.push(x);
            }
        }
    }
    public void pop(){
        if(!stack.empty()){
            int tmp = stack.pop();
            if (tmp == minStack.peek()){
                minStack.pop();
            }
        }
    }
    public int top(){
        if (!stack.empty()){
            return stack.peek();
        }
        return -1;
    }
    public int getMin(){
        if (minStack.empty()){
            return -1;
        }
        return minStack.peek();
    }
}
