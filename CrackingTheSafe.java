import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.StdOut;

/*#753
 * There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.

You can keep inputting the password, the password will automatically be matched against the last n digits entered.

For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.

Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.

Example 1:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.2
Example 2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.4
Note:
n will be in the range [1, 4].
k will be in the range [1, 10].
k^n will be at most 4096.
n = 2
k = 3  0 1 2
0122002110
 */
public class CrackingTheSafe {
	public static String crackSafe(int n, int k) {
        Set<String> visited = new HashSet<String>();
        StringBuilder res = new StringBuilder();
        //construct 0000...000
        for(int i = 0;i < n;i++)
        		res.append('0');
        
        visited.add(res.toString());
        //00001 000011
        for(int i = 0;i < Math.pow(k, n);i++) {
        		String pre = "";
        		if(res.length() - n + 1 <= res.length() - 1)
        			pre = res.substring(res.length() - n + 1, res.length());
        		for(int j = k - 1;j >= 0;j--) {
        			String cur = pre + Integer.toString(j);
        			if(!visited.contains(cur)) {
        				visited.add(cur);
        				res.append(j);
        				break;
        			}
        		}
        }
        return  res.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2, k = 2;
		String res = crackSafe(n,k);
        	StdOut.print("result:" + res);

	}
}
