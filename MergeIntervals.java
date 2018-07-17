import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dataStructure.Interval;

/*Description#56
 * Given a collection of intervals, merge all overlapping intervals.
 * Example:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */

public class MergeIntervals {
	/*超时 T～N2   S~N2?
	 * 
	 */
	 public List<Interval> merge(List<Interval> intervals) {
	     List<Interval> lists = new ArrayList<Interval>();
	     for(int i = 0;i < intervals.size();i++) {
	    	  Interval cur = intervals.get(i);
	    	  lists.add(cur);
	    	  int j = 0;
	    	   for(;j < lists.size();j++) {
	    		   Interval already = lists.get(j);
	    		   if(!(cur.end < already.start || cur.start > already.end)) {
	    			   Interval newInter = new Interval(Math.min(cur.start, already.start),Math.max(cur.end, already.end));
	    			   if(!lists.contains(newInter)) {
	    			    lists.set(j, newInter);
	    			    j--;
	    			   }
	    			   else
	    				   lists.remove(j);
	    		   }
	    	   }
	     }   
	     return lists;
	 }
	 
	 /*Sort T～nlogn S～1 or N
	  * 
	  */
	 public List<Interval> merge2(List<Interval> intervals) {
	    Collections.sort(intervals,new IntervalComparator());
	    List<Interval> list = new ArrayList<Interval>();
	    for(int i = 0;i < intervals.size();i++) {
	    		Interval cur = intervals.get(i);
	    		int endIndex = list.size()-1;
	    		if(list.isEmpty() || list.get(endIndex).end < cur.start)
	    			list.add(cur);
	    		else {
	    			int end = Math.max(list.get(endIndex).end, cur.end);
	    			int start = Math.min(list.get(endIndex).start,cur.start);
	    			list.set(endIndex, new Interval(start,end));
	    		}
	    }
	    return list;
	 }
	 private class IntervalComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start < o2.start? -1: o1.start == o2.start? 0:1;
		}
		 
	 }
}
