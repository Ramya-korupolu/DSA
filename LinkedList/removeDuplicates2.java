Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
Return the linked list sorted as well.

 

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
  
  
  
  
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode pred = res;

        while(head != null){
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                } 
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }

        return res.next;
    }
} 
  
  
