import java.util.HashMap;
import java.util.Map;

/*Description:#242
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
	/*HashTable 17% 42ms 
	 * 
	 */
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) return false;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char ch: s.toCharArray()) 
        		map.put(ch, map.getOrDefault(ch, 0)+1);
        
        for(char ch: t.toCharArray()) {
        		if(!map.containsKey(ch))
        			return false;
        		else {
        			map.put(ch, map.get(ch) - 1);
        			if(map.get(ch) == 0)
        				map.remove(ch, 0);
        		}
        }
        return map.isEmpty();
    }
	/*Hashtable也可以直接用数组实现，只需要存储26个字母 T~N S~1  83% 6ms
	 * 
	 */
	public boolean isAnagramArray(String s, String t) {
		if(s.length()!=t.length()) return false;
         int[] table = new int[26];
         
         for(int i = 0; i < s.length() ; i++) {
        	 	table[s.charAt(i)- 'a']++;
        	 	table[t.charAt(i)- 'a']--;
         }
        for(int i = 0; i < 26;i++)
        		if(table[i] != 0)
        			return false;
        
        return true;
        
    }
	
	
}
