import java.util.Stack;

// SC : O(1)
// TC:O(n)
class bascicCalculatortwo {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        int calc = 0;
        int tail = 0;
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0'; // as c looks like '5' we need to do '5' - '0'
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    calc = calc + num;
                    tail = +num;

                }
                if (lastSign == '-') {
                    calc = calc - num;
                    tail = -num;

                }
                if (lastSign == '*') {
                    calc = calc - tail + (tail * num); //precedence of multipilcation
                    tail = tail * num;

                }
                if (lastSign == '/') {
                    calc = calc - tail + (tail / num);
                    tail = tail / num;

                }
                lastSign = c;
                num = 0;

            }
        }
        return calc;
    }
}

//Using Stack
//TC:O(n)
//O(n)
//227.Basic calculator 2
class Solution {
    public int calculate(String s) {
        if(s == null){
            return 0;
        }
        int num = 0;
        int calc = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<> ();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0'; // as c looks like '5' we need to do '5' - '0'
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    st.push(num);

                }
                if (lastSign == '-') {
                    st.push(-num);

                }
                if (lastSign == '*') {
                    st.push(st.pop() * num);
                }
                if (lastSign == '/') {
                    st.push(st.pop() / num);
                }
                lastSign = c;
                num = 0;
            }
        }
        while(!st.isEmpty()){
            calc = calc + st.pop();
        }
        return calc;
    }
}