Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Input: s = "the sky is blue"
Output: "blue is sky the"


Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.


Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 



class Solution {
    public String reverseWords(String s) {
        Stack<String> reverse = new Stack<>();
        String[] word = s.trim().split(" ");

        for(int i = 0; i < word.length; i++){
            if(word[i].isEmpty()){
                continue;
            }
            reverse.push(word[i]);
        }

       StringBuilder out = new StringBuilder("");
        while(!reverse.isEmpty()){
            out.append(reverse.pop());
            out.append(" ");
        }

        out.setLength(out.length() - 1);
        return out.toString();
    }
}
