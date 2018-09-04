import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*#460
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 /* capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
public class LFUCache {
	private Map<Integer,Integer> vals;
	private Map<Integer,Integer> counts;
	private Map<Integer,LinkedHashSet<Integer>> lists;
	private int min,count,cap;
	 
	 public LFUCache(int capacity) {
		 vals = new HashMap<Integer,Integer>();//key,vals
		 counts = new HashMap<Integer,Integer>();//key,count
		 lists = new HashMap<Integer,LinkedHashSet<Integer>>(); //count,list<key>
		 lists.put(1, new LinkedHashSet<Integer>());
		 this.min = Integer.MAX_VALUE;
		 this.count = 0;
		 this.cap = capacity;
	 }
	    
	    public int get(int key) {
	    		if(vals.containsKey(key)) {
	    			int value = vals.get(key);
	    			int count = counts.get(key);
	    			lists.get(count).remove(key);
	    			if(count == min && lists.get(min).isEmpty()) min++;
	    			counts.put(key, count + 1);
	    			if(!lists.containsKey(count + 1))
	    				lists.put(count + 1, new LinkedHashSet<Integer>());
	    			lists.get(count + 1).add(key);
	    			return value;
	    		}
	    		else return -1;
	    		
	    }
	    
	    public void put(int key, int value) {
	       if(vals.containsKey(key)) {
	    	   	int count = counts.get(key);
	    	   	counts.put(key, count + 1);
	    	   	lists.get(count).remove(key);
	    	   	if(count == min && lists.get(min).isEmpty()) min++;
	    	   	if(!lists.containsKey(count + 1))
	    	   		lists.put(count + 1, new LinkedHashSet<Integer>());
	    	   	lists.get(count + 1).add(key);
	       }
	       else {
	    	   	count++;
	    	   	vals.put(key, value);
	    	   	counts.put(key, 1);
	    	   	this.min = 1;
	    	   	if(count > this.cap) {
	    	   		int delkey = lists.get(min).iterator().next();
	    	   		lists.get(min).remove(delkey);
	    	   		counts.remove(delkey);
	    	   		vals.remove(delkey);
	    	   		count--;
	    	   	}
	       }
	    }
}
