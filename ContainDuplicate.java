import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Description:#217 easy
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class ContainDuplicate {
	//Sorting T~nolog S~1
	 public boolean containsDuplicate(int[] nums) {
	        Arrays.sort(nums);
	        for(int i = 0;i < nums.length - 1;i++)
	        		if(nums[i] == nums[i+1])
	        			return true;
	        return false;
	}
	 //HashTable T~N S~N
	 public boolean containsDuplicate2(int[] nums) {
	     if(nums == null || nums.length == 0) return false;
	     Set<Integer> set = new HashSet<Integer>();
	     
	     for(int i = 0;i < nums.length;i++) {
	    	 	if(set.contains(nums[i])) return true;
	    	 	else set.add(nums[i]);
	     }
	     return false;
	}
}
