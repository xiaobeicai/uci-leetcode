/*#670 medium
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
 * Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]
 */
public class MaximumSwap {
	public int maximumSwap(int num) {
        if(num  < 10) return num;
        int len = 0;
        int tmp = num,max = 0,index = 0;
        while(tmp > 0) {
        		len++;
        		tmp /= 10;
        }
        int[] nums = new int[len];
        tmp = num;
        while(tmp > 0) {
        		nums[--len] = tmp % 10;
        		if(max <= nums[len]) {
        			max = nums[len];
        			index = len;
        		}
        		tmp /= 10;
        		
        
        		
    }
	
}
