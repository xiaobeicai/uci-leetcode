import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Description:#127
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<String>(wordList);
		Set<String> visited = new HashSet<String>();
		visited.add(beginWord);
		int dist = 1;
		while(!visited.contains(endWord)) {
			Set<String> temp = new HashSet<String>();
			
			for(String word:visited) {
				char[] chs = word.toCharArray();
				for(int i = 0;i < word.length();i++) {
					for(char c = 'a';c < 'z';c++)
						if(chs[i] != c) {
							char cc = chs[i];
							chs[i] = c;
							String str = new String(chs);
							if(wordSet.contains(str)) {
								temp.add(str);
								wordSet.remove(str);
							}
							chs[i] = cc;
						}
				}
			}
			dist++;
			if(temp.size() == 0) //never get to the end word
				return 0;
			visited = temp;
		}
		return dist;
    }
}
