import java.util.HashMap;
import java.util.Map;

import dataStructure.RandomListNode;

/*#138
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */

public class CopyListWithRandomPointer {
	
	//copy means that you need to create a set of new nodes to copy the nodes
	/*HashMap T~N S~N
	 * 
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
        //corner case
		if(head == null) return head;
        //copy all nodes to map
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode node = head;
        while(node != null) {
        	map.put(node, new RandomListNode(node.label));
        	node = node.next;
        }
        
        //assign the next and randome node
        node = head;
        while(node != null) {
        	map.get(node).next = map.get(node.next);
        	map.get(node).random = map.get(node.random);
        	node = node.next;
        }
        
        return map.get(head);
    }
	/*Only node can finish it T~N S~N
	 * 
	 */
	public RandomListNode copyRandomList2(RandomListNode head) {
        //corner case
		if(head == null) return head;
        //copy all nodes to map
        RandomListNode node = head,next;
        while(node != null) {
        		next = node.next;
        		RandomListNode cur = new RandomListNode(node.label);
        		node.next = cur;
        		node = next;
        		
        }
        
        return head;
    }
}
