import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*Description:#15
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets 
 * in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
	/*超时
	 * 
	 */
	public List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0;i < size;i++)
        		map.put(nums[i], i);
        for(int i = 0;i < size-1;i++)
        		for(int j = i+1;j < size;j++) {
        			int complement = 0 - nums[i] - nums[j];
        			if(map.containsKey(complement) && map.get(complement) > j ) {
        				List<Integer> list = new LinkedList<Integer>();
        				list.add(nums[i]);
        				list.add(nums[j]);
        				list.add(complement);
        				if(!res.contains(list))
        					res.add(list);
        			}
        	}
        return res;
    }

	public List<List<Integer>> threeSum2(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
       
        for(int i = 0;i < size-2;i++) {
        	if(i==0||nums[i]!= nums[i-1]) {//避免重复list
        		int lo = i+1;
        		int hi = size-1;
        		while(lo < hi) {//夹逼法
        			if(nums[lo] + nums[i] + nums[hi] == 0) {
        				res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
        				while(lo < hi && nums[lo]==nums[lo+1]) lo++; //跳过重复的值
        				while(lo < hi && nums[hi]==nums[hi-1]) hi--;
        				lo++;
        				hi--;
        			}
        			else if(nums[i] + nums[lo] + nums[hi] < 0) 
        				lo++;
        			else hi--;
        			}
        		}
        }
        return res;
    }
}
