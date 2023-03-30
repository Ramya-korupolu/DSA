Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Input: s = "aba"
Output: true


Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.


Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.





class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalin(s, left + 1, right) || isPalin(s, left, right -1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isPalin(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
