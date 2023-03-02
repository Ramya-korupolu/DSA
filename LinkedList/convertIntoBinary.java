Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.
  
  
  
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10




class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int length = 0;

        while(temp != null){
            length++;
            temp = temp.next;
        }

        int val = 0, power = length - 1;

        temp = head;
        while(temp != null){
            val += (temp.val * Math.pow(2, power));
            power--;
            temp = temp.next;
        }

        return val;
    }
}
