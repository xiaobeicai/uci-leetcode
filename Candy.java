import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*#135
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {
	/* T～N S～N
	 * 
	 */
	public int candy(int[] ratings) {
		int len = ratings.length;
		if(ratings == null || len == 0) return 0;
		if(len == 1)return 1;
		if(len == 2) {
			if(ratings[0] == ratings[1]) return 2;
			else return 3;
		}
		int[] sum = new int[len];
		for(int i = 0;i < len;i++)
			sum[i] = 1;
		
		for(int i = 1;i < len;i++) {
			if(ratings[i] > ratings[i-1])
				sum[i] = sum[i-1] + 1;
		}
		int res = 0;
		for(int i = len-2;i >=0;i--) {
			if(ratings[i] > ratings[i+1])
				sum[i] = Math.max(sum[i], sum[i+1] + 1);
			res += sum[i];
		}
		
		return res + sum[len-1];
    }
}
