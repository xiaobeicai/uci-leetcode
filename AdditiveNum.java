import java.math.BigInteger;

import edu.princeton.cs.algs4.StdOut;

/*#306
 * Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true 
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true 
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
Follow up:
How would you handle overflow for very large input integers?
 */
public class AdditiveNum {
	public static boolean isAdditiveNumber(String num) {
        int len = num.length();
        //i and j is the length of x1 and x2
        for(int i = 1;i <= len/2;i++) {
        		if(num.charAt(0) == '0' && i > 1) return false;
        		BigInteger x1 = new BigInteger(num.substring(0, i));
        		for(int j = 1;Math.max(i, j) < len - i- j;j++) {
        			if(num.charAt(i) == '0' && j > 1) break;
        			BigInteger x2 = new BigInteger(num.substring(i,i+j));
        			if(isValid(x1,x2,i+j,num)) return true;
        		}
        }
        return false;
    }
	
	public static boolean isValid(BigInteger x1,BigInteger x2,int start,String num) {

		if(start == num.length()) return true;
		x2 = x1.add(x2);
		x1 = x2.subtract(x1);
		String sum = x2.toString();
		return num.startsWith(sum,start) && isValid(x1,x2,start + sum.length(),num);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "112358";
		boolean res = isAdditiveNumber(s);
        	StdOut.print("result:" + res);

	}
}
