Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]


Input: n = 1
Output: ["()"]
 

Constraints:
1 <= n <= 8
  
  
  
  
class Solution {
    ArrayList<String> comb = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        getComb(n, 0, 0, "");
        return comb;
    }

    public void getComb(int n, int left, int right, String str){
        if(left == n && right == n){
            comb.add(str);
            return;
        }
        if(left < n){
            getComb(n, left + 1, right, str + "(");
        } 
        if(right < left){
            getComb(n, left, right + 1, str + ")");
        }
        return;
    }
}
