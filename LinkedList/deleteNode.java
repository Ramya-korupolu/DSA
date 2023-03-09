A simple solution is to traverse the linked list until you find the node you want to delete. 
But this solution requires a pointer to the head node, which contradicts the problem statement.
The fast solution is to copy the data from the next node to the node to be deleted and delete the next node. Something like the following.


// Find next node using next pointer
struct Node *temp  = node_ptr->next;

// Copy data of next node to this node
node_ptr->data  = temp->data;

// Unlink next node
node_ptr->next  = temp->next;

// Delete next node
free(temp);


public void deleteNode(Node Node_ptr)
    {
        Node temp = Node_ptr.next;
        Node_ptr.data = temp.data;
        Node_ptr.next = temp.next;
        temp = null;
    }
 


public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
 
        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);
 
        System.out.println("Before deleting");
        llist.printList();
 
        /* I m deleting the head itself.
        You can check for more cases */
        llist.deleteNode(llist.head);
 
        System.out.println("\nAfter Deleting");
        llist.printList();
    }
