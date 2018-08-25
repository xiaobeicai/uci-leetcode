import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*#336
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs {
	//TLE
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList();
        if(words == null || words.length == 0) return res;
        int len = words.length;
        for(int i = 0;i < len;i++) 
        		for(int j = 0;j < len;j++)
        			if(i != j ) {
        				String left= words[i];
        				String right = words[j];
        				if
        				if(isPalindrome(str)) {
        					List<Integer> list = new ArrayList();
        					list.add(i);
        					list.add(j);
        					res.add(list);
        				}
        			}
        return res;
    }
	public boolean isPalindrome(String word) {
		if(word == null || word.length() == 0) return true;
		int len = word.length();
		for(int i = 0;i < len/2;i++) {
			if(word.charAt(i) != word.charAt(len - i - 1))
				return false;
		}
		return true;
	}
	
	public List<List<Integer>> palindromePairs2(String[] words) {
		List<List<Integer>> res = new ArrayList();
        if(words == null || words.length == 0) return res;
        int len = words.length;
        Map<String,Integer>  map = new HashMap<String,Integer>();
        for(int i = 0;i < len;i++)
        		map.put(words[i], i);
        
        for(int i = 0;i < len;i++) 
    		for(int j = 0; j <= words[i].length();j++) {
    			String s1 = words[i].substring(0, j); //‘a’ ‘’
    			String s2 = words[i].substring(j);//start from j
    			if(isPalindrome(s1)) {
    				String str2rev = new StringBuilder(s2).reverse().toString();
    				if(map.containsKey(str2rev) && map.get(str2rev) != i) {
    					List<Integer> list = new ArrayList();
    					list.add(map.get(str2rev));
    					list.add(i);
    					res.add(list);
    				}
    			}
    			if(isPalindrome(s2)) {
    				String str2rev = new StringBuilder(s1).reverse().toString();
    				if(map.containsKey(str2rev) && map.get(str2rev) != i && s2.length() != 0) {
    					List<Integer> list = new ArrayList();
    					list.add(i);
    					list.add(map.get(str2rev));
    					res.add(list);
    				}
    			}
    		}
    
    return res;
    }
}
