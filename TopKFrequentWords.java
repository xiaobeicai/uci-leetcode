import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

/*#692 medium
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, 
then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {
	//bucket T~Nlogk S~N
	public static List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList();
        if(words == null || words.length == 0) return res;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0;i < words.length;i++) {
        		String word = words[i];
        		map.put(word, map.getOrDefault(word, 0) + 1);
         }
        
        List<String>[] list = new ArrayList[words.length + 1];
        for(String word : map.keySet()) {
        		int val = map.get(word);
        		if(list[val] == null) list[val] = new ArrayList();
        		list[val].add(word);
        }
        for(int i = words.length - 1; i >= 0 && k > 0;i--) {
        		if(list[i] != null) {
        			List<String> sublist = list[i];
        			Collections.sort(sublist);
        			for(int j = 0;j < sublist.size() && k > 0;j++) {
        				res.add(sublist.get(j));
        				k--;
        			}
        		}
        }
        return res;
    }
	
	//["i", "love", "leetcode", "i", "love", "coding"]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		List<String> res = topKFrequent(words,k);
        	StdOut.print("result:" + res);
	}
}
