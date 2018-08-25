/*#680 medium
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
aaabbcdcbaaa
 */
public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 1) return true;
        int len = s.length();
        int left = 0, right = len -1;
        	while(left < right &&left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
        		left++;
        		right--;
        	}
        	if(left >= right) return true;
        	
        	String l = s.substring(0, left) + s.substring(left + 1,len);
        	String r = s.substring(0,right) + s.substring(right+ 1,len); 
        	return isPalindrome(l) || isPalindrome(r);  
    }
	
	public boolean isPalindrome(String s) {
		 if(s == null) return false;
	        if(s.length() == 1) return true;
	        int len = s.length();
	        int left,right;
	        if(len % 2 ==0) {
	        		left = len/2 - 1;
	        		right = len/2;
	        }
	        else {
	        		left = len / 2;
	        		right = len/2;
	        }
	        	while(left >= 0 && right <len && s.charAt(left) == s.charAt(right)) {
	        		left--;
	        		right++;
	        	}
	        	if(left == -1 && right == len) return true;
	        	else return false;
	}
}
