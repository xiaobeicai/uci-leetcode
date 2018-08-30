import java.util.Arrays;

/*#53
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {
	/*Two-Pointers T～N2
	 * 超时
	 */
	public int maxSubArray(int[] nums) {
		int size = nums.length;
    	if(size == 1) return nums[0];
    	int max = Integer.MIN_VALUE,index = 0;
    int[] sum = new int[(1+size) * size/2];
    	for(int i = 0;i < size;i++) {// low
    		sum[index] = nums[i];
    		if(max < sum[index])
				max = sum[index];
            index++;
    		for(int j = i+1;j < size;j++) {//hi
    			sum[index] = sum[index-1] + nums[j];
    			if(max < sum[index])
    				max = sum[index];
    			index++;
    		}
    	}
    	return max;
	}
	/*T～N 动态规划 or 贪心？
	 * key： maxEndingHere 和 maxSofar
	 */
	public int maxSubArray2(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		int size = nums.length;
		for(int i = 1;i < size;i++) {
			maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]); //在 当前值 和 上一个endmax与当前值之中选择较大值
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
}
