import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

/*#556
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same 
 * digits existing in the integer n and is greater in value than n. 
 * If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21
 

Example 2:

Input: 21
Output: -1
 */
public class NextGreaterElementIII {
	public int nextGreaterElement(int n) {
        int[] nums = new int[12];
        int len = 0;
        int flag = n;
        while(flag > 0) {
        		int temp = flag % 10;
        		flag /= 10;
        		nums[len++] = temp; 
        }
        
        if(len == 1) return -1;//个位数不存在，而不是它本身
        for(int i = 0;i < len/2;i++) {
        		int temp = nums[i];
        		nums[i] = nums[len - i -1];
        		nums[len - i - 1] = temp;
        }
        
        for(int i = len -2;i >= 0;i--) {
        		if(nums[i] < nums[i + 1]) {
        			int min = nums[i+1]; 
        			int index = i + 1;
        			for(int j = len-1;j > i;j--)
        				if(nums[j] > nums[i] && nums[j] < min) {
        					min = nums[j];
        					index = j;
        				}
        			nums[index] = nums[i];
        			nums[i] = min; 
        			Arrays.sort(nums,i+1,len);
        			long res = 0;
        			for(int k = 0;k < len;k++)
        				res = res * 10 + nums[k];
        			if(res > Integer.MAX_VALUE)
        				return -1;
        			else return (int)res;
        		}
        }
        return -1;
    }
}
