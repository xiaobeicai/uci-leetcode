import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*#146
Design and implement a data structure for Least Recently Used (LRU)(最久远的) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2)
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

public class LRUCache {
	class DLinkedNode{
		 int key;
		 int val;
		 DLinkedNode pre;
		 DLinkedNode post;
	}

	private void addNode(DLinkedNode node) {
		node.pre = this.head;
		node.post = head.post;
		
		head.post.pre = node;
		head.post = node;
	}
	private void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		
		pre.post = post;
		post.pre = pre;
	}
	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}
	private DLinkedNode popTail() {
		DLinkedNode node = tail.pre;
		this.removeNode(node);
		return node;
	}
	 private Map<Integer,DLinkedNode> map;
	 private int capacity,count;
	 private DLinkedNode head,tail;
	 
	 public LRUCache(int capacity) {
	        map = new HashMap<Integer,DLinkedNode>();
	        this.count = 0;
	        this.capacity = capacity;
	        
	        head = new DLinkedNode();
	        head.pre = null;
	        
	        tail = new DLinkedNode();
	        tail.post = null;
	        
	        head.post = tail;
	        tail.pre = head;
	   }
	    
	    public int get(int key) {
	    		DLinkedNode node = map.get(key);
	        if(node == null) return -1;
	        
	        this.moveToHead(node);
	        	return node.val;
	    }
	    
	    public void put(int key, int value) {
	       DLinkedNode node = map.get(key);
	       if(node == null) {
	    	   DLinkedNode newNode = new DLinkedNode();
	    	   	newNode.key = key;
	    	   	newNode.val = value;
	    	   	map.put(key, newNode);
	    	   	this.addNode(newNode);
	    	   	count++;
	    	   	if(count > this.capacity) {
	    	   		DLinkedNode tail = this.popTail();
	    	   		map.remove(tail.key);
	    	   		count--;
	    	   	}
	       }
	       else {
	    	   	node.val = value;
	    	   	this.moveToHead(node);
	       }
	    }
}
