/*Description#21
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
     	ListNode res = new ListNode(0);
     	ListNode list = res;//因为list一直在等于list.next最后到达末端，所以需要res.next获得起点
        while(l1 != null && l2 != null) {
        		if(l1.val <= l2.val) {
				list.next  = l1;
				l1  = l1.next;
        		}
        		else{
        			list.next = l2;
        			l2 = l2.next;
        		}
        		list = list.next;
        }
        if(l1 != null) list.next = l1;
        if(l2 != null) list.next = l2;
        
        return res.next; 
    }
}
