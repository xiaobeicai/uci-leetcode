import dataStructure.ListNode;

/*#143 medium
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
	public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head,fast = head;
        //find the middle
        while(fast.next != null && fast.next.next != null) {
        		slow = slow.next;
        		if(fast.next != null)
        		fast = fast.next.next;
        }
        //reverse the half after the middle
        ListNode preMid = slow,preCur = slow.next;
        while(preCur.next != null) {
        		ListNode pr = preCur.next;
        		preCur.next = pr.next;
        		pr.next = preMid.next;
        		preMid.next = pr;
        }
        ListNode p1 = head,p2 = slow.next;
        while(p1 != preMid) {
        	 preMid.next = p2.next;
        	 p2.next = p1.next;
        	 p1.next = p2;
        	 p1 = p2.next;
        	 p2 = preMid.next;
        }
        return;
    }
}
