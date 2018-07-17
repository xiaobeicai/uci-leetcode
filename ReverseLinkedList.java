import dataStructure.ListNode;

/*Description#206
 * Reverse a singly linked list.
 * 1->2->3->null
 * null->3->2->1
 */

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode pre = null,cur = head;
		while(cur != null) {
			ListNode nextNode = cur.next;  
			cur.next = pre; 
			pre = cur;
			cur = nextNode;
		}
		return  pre;
    }
	
}
