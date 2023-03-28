Find the Index of the First Occurrence in a String


Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.


Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

  
Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
  
  
  
  
  //using for loop
  
  class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack.length() < needle.length()){
            return -1;
        }

        int ptr2 = 0;
        for(int ptr1 = 0; ptr1 < needle.length(); ptr1++){
            if(haystack.charAt(ptr1) == needle.charAt(ptr2)){
                ptr2++;
            } else {
                ptr1 = ptr1 - ptr2;
                ptr2 = 0;
            }
            if(ptr2 == needle.length()){
                return ptr1 - ptr2 + 1;
            }
        }

        return -1;
    }
}



// using while loop

class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack.length() < needle.length()){
            return -1;
        }

        int ptr1 = 0, ptr2 = 0;
        int index = 0;
        int hayLen = haystack.length(), needleLen = needle.length();

        while(ptr1 < hayLen){
            if(haystack.charAt(ptr1) != needle.charAt(ptr2)){
                ptr1++;
            } else {
                index = ptr1;
                while(ptr2 < needleLen && ptr1 < hayLen){
                    if(haystack.charAt(ptr1) != needle.charAt(ptr2)){
                        ptr2 = 0;
                        break;
                    }
                    ptr1++;
                    ptr2++;
                }
                if(ptr2 == needleLen){
                    return index;
                }
                ptr1 = index + 1;
            }
        }

        return -1;
    }
}
