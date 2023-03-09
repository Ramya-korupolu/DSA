Given the head of a singly linked list, return true if it is a 
palindrome or false otherwise.
  

Input: head = [1,2,2,1]
Output: true
  
Input: head = [1,2]
Output: false
  
  

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode mid = getMidNode(head);

        ListNode right = reverseSecondHalf(mid);
        ListNode left = head;

        while(right != null){
            if(right.val != left.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }

        return true;

    }

    public ListNode reverseSecondHalf(ListNode mid){
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    public ListNode getMidNode(ListNode head){
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
