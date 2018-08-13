/*#647 medium
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {
	/*brute force T~N2
	 * 
	 */
	public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length(), count = 0;
        
        for(int i = 0;i <= len - 1;i++)
        		for(int j = i + 1;j <= len;j++)
        		{
        			String sub = s.substring(i, j);
        			if(isPalindrome(sub)) count++;
        		}
        
        return count;
    }
	
	public boolean isPalindrome(String s) {
		int len = s.length();
		for(int i = 0;i < len/2;i++)
			if(s.charAt(i) != s.charAt(len-1-i))
				return false;
		
		return true;
	}
	private int num = 0;
	//T~N2 faster
	public int countSubstrings2(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        
        for(int i = 0;i <= len - 1;i++) {
        		helper(s,i,i);
        		helper(s,i,i+1);
        }    
        return num;
    }
	
	public void helper(String s,int i, int j) {
		while(i >= 0 && j < s.length() &&(s.charAt(i) == s.charAt(j))) {
			num++;
			i--;
			j++;
		}
	}
	
	
}
