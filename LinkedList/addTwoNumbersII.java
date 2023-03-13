You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  
  
  
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]


Input: l1 = [0], l2 = [0]
Output: [0]





class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);

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

        return reverseList(l1);
        
    }

    public ListNode reverseList(ListNode head){

        if(head == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }
}
