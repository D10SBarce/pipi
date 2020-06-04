public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        int left = 0;
        char[] str = A.toCharArray();
        for (int i = 0; i < n; i++) {
            if ('(' == str[i]){
                left++;
            }
            else if (')' == str[i]){
                left--;
            }else {
                return false;
            }
        }
        return left == 0;
    }


}