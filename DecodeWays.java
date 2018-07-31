import edu.princeton.cs.algs4.StdOut;

/*#91
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226" 123     "22673215"  1233
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
	//dp dp[i] = dp[i-1] + dp[i-2]
 	public static int numDecodings(String s) {
 		int len = s.length();
 		if(len == 0) return 0;
        int[] dp = new int[len+1];
        
        dp[len] = 1;
        dp[len-1] = s.charAt(len-1) != '0' ? 1:0;
        
        for(int i = len-2;i >= 0;i--) {
        		if(s.charAt(i) == '0') continue;
        		else dp[i] = (Integer.parseInt(s.substring(i, i+2)) <= 26 ? dp[i+1] + dp[i+2] : dp[i+1]);
        }
        
        return dp[0];
        
    }
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "10";
		int res = numDecodings(s);
        	StdOut.print("result:" + res);

	}
}
