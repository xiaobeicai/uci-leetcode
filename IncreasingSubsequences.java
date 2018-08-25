import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.princeton.cs.algs4.StdOut;

/*#491
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, 
 * and the length of an increasing subsequence should be at least 2 .
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of 
 * increasing sequence.
 */
public class IncreasingSubsequences {
	public static List<List<Integer>> findSubsequences(int[] nums) {
		//avoid duplicates
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        helper(res,new ArrayList(),nums,0,-101);
        List result = new ArrayList(res);
        return result;
    }
	public static void helper(Set<List<Integer>> res,List<Integer> list,int[] nums,int start,int last) {
		if(list.size() >= 2)
			res.add(new ArrayList(list));
		if(start == nums.length) return;
		int pre = -101;
		for(int i = start;i < nums.length;i++) {
			if(pre != nums[i] && last <= nums[i]) {
				list.add(nums[i]);
				helper(res,list,nums,i+1,nums[i]);
				list.remove(list.size()-1);
				pre = nums[i];
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,6,7,7};
		List<List<Integer>> res= findSubsequences(a);
        	StdOut.print("result:" + res);
	}
}
