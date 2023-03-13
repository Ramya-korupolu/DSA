You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
  
  
  
Input: head = [1,2,3,4]
Output: [1,4,2,3]


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]




class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null){
            return;
        }
        
        //finging mid
        ListNode mid = findMid(head);
        
        //reversing the second half
        ListNode head2 = reverseList(mid.next);
        mid.next = null;
        
        //merging both the lists
        head = mergeLists(head, head2);

        return;
    }



    public ListNode mergeLists(ListNode left, ListNode right){

        ListNode nextL = null, nextR = null;

        while(right != null){
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = nextL;

            right = nextR;
            left = nextL;
        }
        return left;
    }



    public ListNode findMid(ListNode head){

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
