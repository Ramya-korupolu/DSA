Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
  
Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]


class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next, preNode = head;
        int preVal = head.val; 

        while(temp != null){
            if(preVal == temp.val){
                preNode.next = temp.next;
            } else {
                preNode = preNode.next;
            }
            preVal = temp.val;
            temp = temp.next;
        }

        return head;
    }
}
