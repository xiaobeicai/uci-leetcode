import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

/*#274
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndex {
	public static int hIndex(int[] citations) {
		int len = citations.length;
		if(citations == null || len == 0 ) return 0;
        int[] bucket = new int[len+1];
        
        for(int i = 0;i < len;i++) {
        		if(citations[i] >= len)
        			bucket[len]++;
        		else
        			bucket[citations[i]]++;
        }
        
        int count = 0;
        for(int i = len;i >= 1;i--) {
        		count += bucket[i];
        		if(count >= i)
        			return i;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {100};
		int index = hIndex(c);
        	StdOut.print("result:" + index
        			);

	}
}
