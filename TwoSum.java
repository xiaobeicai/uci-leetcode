import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

class Solution {
	    public static int[] twoSum(int[] nums, int target) {   //Brute&first T~O(N2);S O(1)
	    	int[] res = new int[2];
	        for(int i = 0; i < nums.length;i++ )
	            for(int j = i + 1; j< nums.length;j++)
	                if( i + j == target) {
	                    res[0] = i;  
	                    res[1] = j;
	                    return res;
	                }
	        throw new IllegalArgumentException("No two sum solution");
	    }
	    /*
	     * Two-Pass HashTable:trade space for time
	     * T~O(N);S O(N)
	     * reduce the look up time from N to 1 but increase the space from 1 to N
	     * Sometimes, if any collision happens, the look up time will increase to N
	     * But look up in hash table should be amortized 1  as long as the hash function was chosen carefully.
	     * 因为最后返回的是index，所以key为nums[i],value为i更合适
	     */
	    public static int[] TwoSumTwoPassHashTable(int[] nums, int target) {  
	    		Map<Integer,Integer> map = new HashMap<>();
	    		for (int i = 0; i< nums.length; i++) {
	    			map.put(nums[i], i);
	    		}
	    		
	    		for(int i = 0; i < nums.length; i++) {
	    			int completement = target - nums[i];
	    			if(map.containsKey(completement) && map.get(completement) != i)
	    				return new int[] {i, map.get(completement)};
	    		}
	    		 throw new IllegalArgumentException("No two sum solution");
	    }
	    /*
	     * One-Pass HashTable:
	     * 复杂度一致，但是比S2运行速度更快。
	     */
	    
	    public static int[] TwoSumOnePassHashTable(int[] nums, int target) {  
	    	Map<Integer,Integer> map = new HashMap<>();
    		
    		for(int i = 0; i < nums.length; i++) {
    			int completement = target - nums[i];
    			if(map.containsKey(completement) && map.get(completement) != i)
    				return new int[] {i, map.get(completement)};
    			map.put(nums[i], i);
    		}
    		 throw new IllegalArgumentException("No two sum solution");
    }
	    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,7,11,15};
		int target = 9;
		int[] res = twoSum(a,target);
        	StdOut.print("result:" + res);

	}
 }
