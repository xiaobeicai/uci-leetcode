import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

/*#689 hard
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Note:
nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).
 */
public class MaximumSumOfThreeNonOverlappingSubarrays {
	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i < nums.length;i++)
        		sum[i] += sum[i-1] + nums[i];
        int[] A = new int[nums.length];
        A[0] = sum[k-1];
        for(int i = 1;i < nums.length - k + 1;i++)
        		A[i] = sum[i + k - 1] - sum[i-1];
        
        int[][] dp = new int[4][nums.length];
        dp[1][0] = A[0];
        
        for(int i = 1;i < nums.length-2 * k;i++) 
        		dp[1][i] = Math.max(A[i], dp[1][i-1]);
        
        for(int i = k;i < nums.length - k;i++) {
        		dp[2][i] = Math.max(dp[1][i - k] + A[i] , dp[2][i-1]);
        }
        
        for(int i = 2 * k;i < nums.length;i++) {
        		dp[3][i] = Math.max(dp[2][i-k] + A[i], dp[3][i-1]);
        }
        int limit = nums.length, start = 2 * k;
        int[] res = new int[3];
        for(int i = 3;i > 0;i--) {
        		int max = 0,pos = 0;
        		for(int j = start;j < limit;j++) {
        			if(max < dp[i][j]) {
        				max = dp[i][j];
        				pos = j;
        			}
        		}
        		res[i-1] = pos;
        		limit = pos - k + 1;
        		start = Math.max(0, (i-2) * k);
        }
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,13,20,19,19,2,10,1,1,19};
		int k = 3;
		int[] res = maxSumOfThreeSubarrays(nums,k);
        	StdOut.print("result:" + res);
	}
}
