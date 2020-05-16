import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;


public class TestDemo {
    class StockSpanner {
        private Stack<Integer> priceS;
        private Stack<Integer> count;


        public StockSpanner() {
            priceS = new Stack<>();
            count = new Stack<>();
        }

        public int next(int price) {
            int n=1;
            while(!priceS.isEmpty()&&price>=priceS.peek()) {
                priceS.pop();
                n += count.pop();
            }
            priceS.push(price);
            count.push(n);
            return n;
        }

    }
    class Solution {
        private   int isOper(int num1,int num2,String fuhao){
            if (fuhao.equals("+")){
                return  num1 + num2;
            }
            else  if (fuhao.equals("-")){
                return num1 - num2;
            }
            else if (fuhao.equals("*")){
                return num1 * num2;
            }
            else{
                return num1 / num2;
            }


        }
        private  boolean isnum(String n){
            if(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/") ){
                return true;
            }
            return false;
        }
        public int evalRPN(String[] tokens) {
            Stack<Integer> num = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if (isnum(tokens[i])) {
                    int num1 = num.pop();
                    int num2 = num.pop();
                    num.push(isOper(num2, num1, tokens[i]));
                } else {
                    num.push(Integer.parseInt(tokens[i]));
                }

            }
            return num.pop();
        }
    }


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;

        Stack<Integer> s = new Stack<Integer>();
        int index = 0;
        for (int i = 0 ; i < pushA.length ; i++){
            s.push(pushA[i]);

            while (!s.empty() && s.peek() == popA[index]){
                s.pop();
                index++;
            }
        }
        return s.empty();

    }

    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        int score = 0;
        for (String str : ops)
            if (!s.empty() && s.equals(" + ")) {
                int a = s.pop();
                int b = s.pop();
                int c = a + b;
                s.push(a);
                s.push(b);
                s.push(c);
            } else if (!s.empty() && s.equals(" D ")) {
                int d = s.peek();
                int e = (2 * d) + d;
                s.push(e);
            } else if (!s.empty() && s.equals(" C ")) {
                s.pop();
            } else {

                s.push(Integer.parseInt(str));
            }
        while (!s.empty()){
            int f = s.pop();
            score += f;
        }
        return score;
    }
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'&&!s1.isEmpty()){
                s1.pop();
            }else if(S.charAt(i)!='#'){
                s1.push(S.charAt(i));
            }
        }

        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#'&&!s2.isEmpty()){
                s2.pop();
            }else if(T.charAt(i)!='#'){
                s2.push(T.charAt(i));
            }
        }

        if(s1.size()!=s2.size()){return false;}
        while(!s1.isEmpty()){
            if(s1.pop()!=s2.pop()){return false;}
        }
        return true;
    }







}
