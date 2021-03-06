/*#400
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class NthDigit {
	//TLE
	public int findNthDigit(int n) {
		int len = 1,count = 0;
        while(n > 0) {
        		n -= len;
        		count++;
        		if((count + 1) % Math.pow(10,len) == 0)
        			len++;
        }
        int res = 0;
        while(n <= 0) {
        		res = count % 10;
        		count /= 10;
        		n++;
        }
        return res;
    }
	
	public int findNthDigit2(int n) {
		int len = 1,start = 1;
        long count = 9; //一定要改成long 才能通过
	       while(n > len * count) {
	    	   		n -= len * count ;
	    	   		len++;
	    	   		count *= 10;
	    	   		start *= 10;
	       }
	       
	      start += (n-1) / len; //10
	      int offset = n % len;
	      offset = offset > 0 ? len - offset:offset;
          while(offset > 0){
              start /= 10;
              offset--;
          }
	      return start%10;
    }
	
}
