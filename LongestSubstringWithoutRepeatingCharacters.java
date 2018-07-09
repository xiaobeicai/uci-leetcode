import java.util.HashMap;
import java.util.Map;

/*Description:#3
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	/*理解题意:有重复项后，不是从重复项开始重新算，而是从之前重复的值的下一个开始
	 * 超时-brute force
	 */
	public int lengthOfLongestSubstring(String s) {
		int size = s.length();
        int len = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i < size;i++) {
        		char ch = s.charAt(i);
        		if(map.containsKey(ch)) {
        			if(max < len)
        				max =len;
        			len = 0;
        			i = map.get(ch) + 1;
        			ch = s.charAt(i); //记得改动ch值
        			map.clear();
        		}
        		len++;
        		map.put(ch, i);	
        }
        
        return Math.max(max, len);//考虑到只有一个字符“c” 或 一整串字符都没有重复的情况；
    }
	/*Sliding Window - Two Pointers  
	 * T~2N~N S~min(m,n)
	 */
	public int lengthOfLongestSubstring2(String s) {
		int size = s.length();
        if(size == 0) return 0; 
        int i = 0,j = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
       
        while(i < size && j < size) {
        		if(!map.containsKey(s.charAt(j))) {
        			map.put(s.charAt(j), j);
        			j++;
        			max = Math.max(max, j-i);
        		}
        		else 
        			map.remove(s.charAt(i++));
        }
        
        return max;
	}
	
	/*Two Pointer- Improvement - 没搞懂
	 * a b c d e f c g h i j
	 * 0 1 2 3 4 5 6 7 8 9 10
	 * a0 b1 c2 d3 e4 f5  i = 2
	 * 
	 */
	public int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) 
                i = Math.max(map.get(s.charAt(j)), i);
            
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
	}

}
