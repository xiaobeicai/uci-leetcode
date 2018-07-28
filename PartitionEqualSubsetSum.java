import java.util.Arrays;

/*#416
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
	//dp T~N2 S~N
	public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0 || nums == null) return true;
        
        int sum = 0;
        for(int i = 0;i < len;i++)
        		sum += nums[i];
        if(sum % 2 == 1) return false;
        int vol = sum/2;
        
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for(int i = 0;i < len;i++)
        		for(int j = vol;j >= nums[i];j--) {
        			dp[j] = dp[j] || dp[j - nums[i]];
        		}
        
        return dp[vol];
    }
}
