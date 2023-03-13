Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.
  
  
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]


Input: head = [5], left = 1, right = 1
Output: [5]



method 1:
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        for(int i = 0; i < left - 1; i++){
            prev = temp;
            temp = temp.next;
        }

        if(prev != null){
            prev.next = reverseList(prev, temp, right - left + 1);
        } else {
            head = reverseList(prev, temp, right - left + 1);
        }

        return head;
    }

    

    public ListNode reverseList(ListNode prev, ListNode node, int numbers){

        if(node == null){
            return node;
        }

        ListNode curr = node;
        ListNode next = curr.next;
        int count = 0;

        while(count < numbers){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        node.next = next;
        return prev;


    }
}




method 2:
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0); // created dummy node
        dummy.next = head;
        ListNode prev = dummy; // intialising prev pointer on dummy node
        
        for(int i = 0; i < left - 1; i++)
            prev = prev.next; // adjusting the prev pointer on it's actual index
        
        ListNode curr = prev.next; // curr pointer will be just after prev
        // reversing
        for(int i = 0; i < right - left; i++){
            ListNode forw = curr.next; // forw pointer will be after curr
            curr.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
        }
        return dummy.next;
}
