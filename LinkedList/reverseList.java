Given the head of a singly linked list, reverse the list, and return the reversed list.


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Input: head = [1,2]
Output: [2,1]

Input: head = []
Output: []
  
  

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
}
