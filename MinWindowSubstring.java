import java.util.HashMap;
import java.util.Map;

/*#76 hard
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinWindowSubstring {
	//two pointers
	public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i < t.length();i++)
        		map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        
        int left = 0,minleft = 0,minlen = s.length() + 1,count = 0;
        
        for(int r= 0;r < s.length();r++) {
        		char ch = s.charAt(r);
        		if(map.containsKey(ch)) {
        			map.put(ch, map.get(ch) - 1);
        			if(map.get(ch) >= 0)
        				count++;
        			while(count == t.length()) {
        				 if(minlen > (r - left)) {
        					 minlen = r - left + 1;
        					 minleft = left;
        				 }
        				 
        				char l = s.charAt(left);
        				if(map.containsKey(l)) { 
        					map.put(l, map.get(l) + 1);
        					if(map.get(l) > 0)
        						count--;
        				}
        				left++;
        			}
        		}
        }
        if(minlen == s.length() + 1) return "";
        return s.substring(minleft, minleft + minlen); 
    }
}
