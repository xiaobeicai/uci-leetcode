import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*#284
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2. 
You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	/*
	 * image that we have an array contains 1 million elements. 
	 * If we only want the k element. By using iterator, we can just consume k elements. 
	 * Time complexity is O(k), space is O(1).
	 * By using queue, time complexity will be O(N), space will be O(N) as well, 
	 * which is workable but not so efficiency.
	 * 
	 */
	private Queue<Integer> q;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    q = new LinkedList<Integer>();
	    while(iterator.hasNext()) {
	    		q.add(iterator.next());
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       return q.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return q.poll();
	}

	@Override
	public boolean hasNext() {
	    return q.size() != 0;
	}
}

class PeekingIterator2 implements Iterator<Integer> {
	/*
	 * image that we have an array contains 1 million elements. 
	 * If we only want the k element. By using iterator, we can just consume k elements. 
	 * Time complexity is O(k), space is O(1).
	 * By using queue, time complexity will be O(N), space will be O(N) as well, 
	 * which is workable but not so efficiency.
	 * 
	 */
	private Iterator<Integer> iter;
	private Integer next = null;
	public PeekingIterator2(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    	if(iter.hasNext()) 
	    		next = iter.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer temp = next;
	    if(iter.hasNext())
	    		next = iter.next();
	    else
	    		next = null;
	    return temp;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}