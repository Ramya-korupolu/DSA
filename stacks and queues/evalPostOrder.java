You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

. The valid operators are '+', '-', '*', and '/'.
. Each operand may be an integer or another expression.
. The division between two integers always truncates toward zero.
. There will not be any division by zero.
. The input represents a valid arithmetic expression in a reverse polish notation.
. The answer and all the intermediate calculations can be represented in a 32-bit integer.


Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
           = ((10 * (6 / (12 * -11))) + 17) + 5
           = ((10 * (6 / -132)) + 17) + 5
           = ((10 * 0) + 17) + 5
           = (0 + 17) + 5
           = 17 + 5
           = 22


class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> opr = new Stack<Integer>();
        int res;

        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            char c = s.charAt(0);

            if(s.length() == 1 && !Character.isDigit(c)) {
                int val1 = opr.pop();
                int val2 = opr.pop();
                 
                switch(c) {
                    case '+':
                    opr.push(val2 + val1);
                    break;
                     
                    case '-':
                    opr.push(val2 - val1);
                    break;
                     
                    case '/':
                    opr.push(val2 / val1);
                    break;
                     
                    case '*':
                    opr.push(val2 * val1);
                    break;
                }
            }
             
            else {
                int n = Integer.parseInt(s);
                opr.push(n);
            }
            
        }
        return opr.pop();

    }

}
