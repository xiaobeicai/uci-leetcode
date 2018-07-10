import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

/*Description#155
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
public class MinStack {
	  /** initialize your data structure here. */
	Stack<Integer> stack;
	private int min;
	public MinStack() {
        stack = new Stack<Integer>();
        min  = Integer.MAX_VALUE;
    }
	//double push min
	public void push(int x) {
	  if(x <= min) { //先储存上一个min
		  stack.push(min);
		  min = x;
	  }
	  stack.push(x); //再储存x
		  
	}
	public void pop() {
		if(stack.pop() == min) 
			min = stack.pop();
	}
	
	public int top() {
	   return stack.peek();
	}
	public int getMin() {
	  return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		int min1 = obj.getMin();
		obj.pop();
		int top = obj.top();
		int min2 = obj.getMin();
		StdOut.print("min1:" + min1 + " min2:" + min2+"top:"+top);

	}
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
