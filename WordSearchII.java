import java.util.ArrayList;
import java.util.List;

/*#212
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		int m = board.length,n = board[0].length;
		List<String> res = new ArrayList<String>();
        for(String word:words) {
        		for(int i = 0;i < m;i++)
        			for(int j = 0;j < n;j++) {
        				if(!res.contains(word) && isExist(board,word,i,j,0)) { //in case of repeat
        					res.add(word);
        					break;
        				}
        			}
        }
        
        return res;
    }
	
	private boolean isExist(char[][] board,String word,int i,int j, int index) {
		if(index == word.length()) return true;
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
		if(board[i][j] != word.charAt(index)) return false;
		
		board[i][j] = '*';
		boolean exist = isExist(board,word,i-1,j,index + 1) || isExist(board,word,i+1,j,index + 1) ||isExist(board,word,i,j-1,index + 1) || isExist(board,word,i,j + 1,index + 1);
		board[i][j] = word.charAt(index);
		
		return exist;
	}
}
