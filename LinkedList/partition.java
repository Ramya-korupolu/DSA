Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.




Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]


Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200




class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode leftPtr = left;
        ListNode rightPtr = right;

        while(head != null){
            if(head.val < x){
                leftPtr.next = head;
                leftPtr = leftPtr.next;
            } else {
                rightPtr.next = head;
                rightPtr = rightPtr.next;
            }
            head = head.next;
        }

        leftPtr.next = right.next;
        rightPtr.next = null;

        return left.next;
    }
}
