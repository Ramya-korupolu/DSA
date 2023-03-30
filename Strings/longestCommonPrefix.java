Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Input: strs = ["flower","flow","flight"]
Output: "fl"


Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

  
  
Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.


  
// program

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String sb = strs[0];
        for(int i = 1; i < strs.length; i++){
            sb = getCommonPref(sb, strs[i]);
        }
        return sb;
    }

    public String getCommonPref(String str1, String str2){
        //int index = 0;
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < str1.length() && ptr2 < str2.length()){
            if(str1.charAt(ptr1) != str2.charAt(ptr2)){
                //index = ptr1;
                break;
            }
            ptr1++;
            ptr2++;
            //index++;
        }
        return str1.substring(0, ptr1);
    }
}
