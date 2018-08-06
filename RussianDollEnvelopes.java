import java.util.Arrays;
import java.util.Comparator;

/*#354
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is
 3 ([2,3] => [5,4] => [6,7]).


 */
public class RussianDollEnvelopes {
	//dp T~N2 S～1套用LIS solution
	public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        if(envelopes == null || m == 0) return 0;
        int n = envelopes[0].length;
        if(n != 2) return 0;
        
        Arrays.sort(envelopes,new Comparator<int[]>() {
        		public int compare(int[] a1,int[] a2) {
        			if(a1[0] != a2[0])
        				return a1[0] - a2[0];
        			else
        				return a1[1] - a2[1];
        		}
        });
        int[] dp = new int[m];
        int res = 0;
        for(int i = 0;i < m;i++) {
        		for(int j = 0;j < i;j++) {
        			if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
        				dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        		res = Math.max(res, dp[i]);
        }
        
        return res + 1;
    }
	//BinarySearch T～NlogN S～1
	public int maxEnvelopes2(int[][] envelopes) {
        int m = envelopes.length;
        if(envelopes == null || m == 0) return 0;
        int n = envelopes[0].length;
        if(n != 2) return 0;
        
        Arrays.sort(envelopes,new Comparator<int[]>() {
        		public int compare(int[] a1,int[] a2) {
        			if(a1[0] != a2[0])
        				return a1[0] - a2[0];
        			else
        				return a1[1] - a2[1];
        		}
        });
        int[] dp = new int[m];
        int res = 0;
        
    }
	
	
}
