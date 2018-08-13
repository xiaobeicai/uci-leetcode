/*#459 easy
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple 
 * copies of the substring together. You may assume the given string consists of lowercase English letters only 
 * and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
        if(s == null ||s.length() == 0) return false;
        int len = s.length();
        String sub = "";
        for(int i = 0;i < len/2;i++) {
        		if(len % (i+1) == 0) {
        			sub = s.substring(0,i);
        			int sublen = sub.length(),j = i+1;
        			for(;j < len;j++) {
        				if(s.charAt(j) != sub.charAt(j % sublen)) break;
        			}
        			if(j == len) return true;
        		}
        }
        return false;
    }
}
