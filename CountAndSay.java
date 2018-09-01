import edu.princeton.cs.algs4.StdOut;

/*Description#38
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

"Count and Say problem" Write a code to do following: 
n String to print 
0 1 
1 1 1 
2 2 1 
3 1 2 1 1 
... 
Base case: n = 0 print "1" 
for n = 1, look at previous string and write number of times a digit is seen and the digit itself. In this case, digit 1 is seen 1 time in a row... so print "1 1"
for n = 2, digit 1 is seen two times in a row, so print "2 1" 
for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1" 
for n = 4 you will print "1 1 1 2 2 1" 

Consider the numbers as integers for simplicity. e.g. if previous string is "10 1" then the next will be "1 10 1 1" and the next one will be "1 1 1 10 2 1"
 */
public class CountAndSay {
	public static String countAndSay(int n) {
		int[] num = new int[1];
		num[0] = 1;
        int[] res = countNum(num,1,n-1);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < res.length && res[i] != 0;i++)
        		sb.append(res[i]);
        return sb.toString();
    }
	private static int[] countNum(int[] num,int end,int left) {
		if(left == 0) 
			return num;
		int count = 1;
		int newEnd = 0;
		int[] res = new int[2*end];
		for(int j = 0;j < end;j++) {
			if(j+1 != end && num[j] == num[j+1])
				count++;
			else {
				res[newEnd++] = count;
				res[newEnd++] = num[j];
				count = 1;
			}
		}
		return countNum(res,newEnd,left-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String res = countAndSay(3);
        	StdOut.print("result:" + res);

	}
}
