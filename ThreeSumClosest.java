import java.util.Arrays;

/*#16
 * Given an array nums of n integers and an integer target, 
 * find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
	//T~n2,S~1
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int abs = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length - 2;i++) {
        		int lo = i + 1;
        		int hi = nums.length-1;
        		while(lo < hi) {
        			int sum = nums[i] + nums[lo] + nums[hi];
        			if(sum == target) return target;
        			else if(sum < target) lo++;
        			else hi--;
        			if(Math.abs(sum - target) < abs) {
        				abs = Math.abs(sum - target);
        				res = sum;
        			}
        			}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20};
		int target = -52;
		int res = threeSumClosest(nums,target);
		System.out.println("res:" + res);
	}
}
