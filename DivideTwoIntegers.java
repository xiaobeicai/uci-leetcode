/*#29
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 [−231,  231 − 1]. 
 For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        int sign = 1,ans;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1 ;
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if(ldivisor == 0) return Integer.MAX_VALUE;
        if((ldividend == 0) || (ldividend < ldivisor)) return 0;
        
        long lans = ldivide(ldividend,ldivisor);
        if(lans > Integer.MAX_VALUE) {
        		ans = (sign == 1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        else ans = sign * (int)lans;
        
        return ans;
    }
	public long ldivide(long dividend,long divisor) {
		if(dividend < divisor) return 0;
		
		long sum = divisor;
		long multiple = 1;
		while((sum + sum) <= dividend) {
			sum += sum;
			multiple += multiple;
		}
		return multiple + ldivide(dividend - sum,divisor);
	}
}
