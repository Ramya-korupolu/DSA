Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]




class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        head.next = removeElements(head.next, val);
        return head.val == val? head.next: head;
    }
}
