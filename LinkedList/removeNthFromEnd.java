Given the head of a linked list, remove the nth node from the end of the list and return its head.
 


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]


Input: head = [1], n = 1
Output: []


Input: head = [1,2], n = 1
Output: [1]



// bruteforce method
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);

        if(n == length){
            head = head.next;
            return head;
        }

        ListNode temp = head;
        System.out.print(length - n);
        for(int i = 0; i < length - n - 1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
  

    public int getLength(ListNode head){
        int length = 0;

        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        return length;
    }
}


//method 2 - two pointer Approach
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
