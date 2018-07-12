import java.util.Stack;

/*#232
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {
	/** Initialize your data structure here. */
	private Stack<Integer> stack;
	private Stack<Integer> rev_stack;
    public MyQueue() {
        stack = new Stack<Integer>();
        rev_stack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack.isEmpty()) {
        	 rev_stack.push(stack.pop());
        }
        
        int pop = rev_stack.pop();
        
        while(!rev_stack.isEmpty()) {
        		stack.push(rev_stack.pop());
        }
        
        return pop;
    }
    
    /** Get the front element. */
    public int peek() {
    		while(!stack.isEmpty())
    			rev_stack.push(stack.pop());
       
    		int peek = rev_stack.peek();
            
        while(!rev_stack.isEmpty())
        		stack.push(rev_stack.pop());
            
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
