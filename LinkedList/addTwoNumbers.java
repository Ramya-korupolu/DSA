
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  
  
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
  
Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]



class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        
        temp1 = l1;
        temp2 = l2;
        
        while(temp1 != null && temp2 != null){
            if(temp1.val + temp2.val > 9){
                temp1.val = (temp1.val + temp2.val) % 10;
                if(temp1.next != null){
                    temp1.next.val += 1;
                } else {
                    temp1.next = new ListNode(1);
                }
            } else {
                temp1.val = temp1.val + temp2.val;
            }
            if(temp1.next == null && temp2.next != null){
                temp1.next = new ListNode(0);
            } else if (temp1.next != null && temp2.next == null){
                temp2.next = new ListNode(0);
            } 
            temp1 = temp1.next;
            temp2 = temp2.next;
            
            
            
        }
        return l1;
        
        
    }
}
