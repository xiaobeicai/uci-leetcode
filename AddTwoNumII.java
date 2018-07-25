import java.util.LinkedList;
import java.util.Stack;

import dataStructure.ListNode;

/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

7243 + 564 = 7807
 * 
 */
public class AddTwoNumII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
        		s1.push(l1.val);
        		l1 = l1.next;
        }
        while(l2 != null) {
        		s2.push(l2.val);
        		l2 = l2.next;
        }
        int carry = 0;
        Stack<Integer> s3 = new Stack<Integer>();
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) { //carry should be considered
        		int sum = carry;
        		if(!s1.isEmpty())
        			sum += s1.pop();
        		if(!s2.isEmpty())
        			sum += s2.pop();
        		carry = sum / 10;
        		s3.push(sum % 10);
        }
        
        ListNode res = new ListNode(0);
        ListNode head = new ListNode(s3.pop());
        res.next = head;
        while(!s3.isEmpty()) {
        		ListNode node = new ListNode(s3.pop());
        		head.next = node;
        		head = node;
        }
        
        return res.next;
    }
}
