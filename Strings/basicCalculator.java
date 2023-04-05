Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Input: s = "3+2*2"
Output: 7


Input: s = " 3/2 "
Output: 1


Input: s = " 3+5 / 2 "
Output: 5


  
  Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
  
  


class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            } 
            if((!Character.isDigit(ch) && ch != ' ')|| i == s.length() - 1){
                switch(sign){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }
                sign = ch;
                num = 0;
            }
        } 

        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }
}
