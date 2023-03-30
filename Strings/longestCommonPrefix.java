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


  
// method - 1

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
        int index = 0;
        while(index < str1.length() && index < str2.length()){
            if(str1.charAt(index) != str2.charAt(index)){
                //index = ptr1;
                break;
            }
            index++;
            //index++;
        }
        return str1.substring(0, index);
    }
}



//optimized method

class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        int index = 0;
        while(index < str1.length() && index < str2.length()){
            if(str1.charAt(index) != str2.charAt(index)){
                break;
            }
            index++;
        }
        return str1.substring(0, index);
    }
}
