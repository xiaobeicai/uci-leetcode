import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*#387
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharasterInAString {
	/*T~N S~N
	 * 
	 */
	public int firstUniqChar(String s) {
		if(s.length() == 0 || s == null) return -1;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char ch : s.toCharArray())
        		map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        for(int i = 0;i < s.length();i++) {
        		if(map.get(s.charAt(i)) == 1)
        			return i;
        }
        
        return -1;
    }
}
