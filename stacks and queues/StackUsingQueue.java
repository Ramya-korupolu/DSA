Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
  


class MyStack {

    Queue<Integer> queue = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.add(x);

        for(int i = 0; i < queue.size() - 1; i++){
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
