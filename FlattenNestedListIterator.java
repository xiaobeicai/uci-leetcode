import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import dataStructure.NestedInteger;

/*#341
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * 
 */

public class FlattenNestedListIterator implements Iterator<Integer> {
    private Queue<Integer> q;
    
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<Integer>();
        add(nestedList);
    }
    public void add(List<NestedInteger> nestedList) {
    		for(int i = 0;i < nestedList.size();i++) {
    			if(nestedList.get(i).isInteger())
    				q.add(nestedList.get(i).getInteger());
    			else add(nestedList.get(i).getList());
    		}
    		return;
    }

	@Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
       return !q.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */