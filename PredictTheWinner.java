import edu.princeton.cs.algs4.StdOut;

/*#486
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.
 */
public class PredictTheWinner {
	public static boolean PredictTheWinner(int[] nums) {
		if(nums.length == 1 || nums.length ==2) return true;
		return predict(nums,0,nums.length-1,0,0,true);
    }
	public static boolean predict(int[] nums,int i,int j,int sum_1,int sum_2,boolean isOne) {
		
		int k;
		if(isOne) {
			if(i == j) {
				sum_1 += nums[i];
				return sum_1 > sum_2;
			}
			k = Judge(nums,i,j);
			sum_1 += nums[k];
			
		}
		else {
			if(i == j) {
				sum_2 += nums[i];
				return sum_1 > sum_2;
			}
			k = Judge(nums,i,j);
			sum_2 += nums[k];
		}
		
		if(k == i) return predict(nums,i+1,j,sum_1,sum_2,!isOne);
		else return predict(nums,i,j-1,sum_1,sum_2,!isOne);
	}
	
	public static int Judge(int[] nums,int i,int j) {
		int one_left = nums[i];
		int two_left = Math.max(nums[i+1], nums[j]);
		int one_right = nums[j];
		int two_right = Math.max(nums[i], nums[j-1]);
		int res_left = one_left - two_left;
		int res_right = one_right - two_right;
		return (res_left > res_right? i : j);
	}
	//dp T~N2 S~N2
	public static boolean PredictTheWinner2(int[] nums) {
		if(nums.length == 0 || nums == null) return false;
		if(nums.length == 1 || nums.length ==2) return true;
		
		int len = nums.length;
		int[][] dp = new int[len][len];
		for(int i = 0;i < nums.length;i++) dp[i][i] = nums[i];
		
		for(int i = len - 2;i >= 0;i--)
			for(int j = i + 1;j < len;j++)
				dp[i][j] = Math.max(nums[j] - dp[i][j-1], nums[i] - dp[i+1][j]);
		
		return dp[0][len-1] >= 0;
			
    }
	//dp T~N2 S~N
	public static boolean PredictTheWinner3(int[] nums) {
		if(nums.length == 0 || nums == null) return false;
		if(nums.length == 1 || nums.length ==2) return true;
		
		int len = nums.length;
		int[] dp = new int[len];
		
		for(int i = len - 1;i >= 0;i--)
			for(int j = i;j < len;j++){
				if(i == j)
					dp[i] = nums[i];
				else {
					dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j-1]);
				}
		}
			
		return dp[len-1]>= 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1};
        	StdOut.print("result:" + PredictTheWinner(nums));
	}
}
