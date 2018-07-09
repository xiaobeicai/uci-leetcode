/*Description:#79
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
  ]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch {
	/*深度搜索用递归
	 * 
	 */
	
	public boolean existTrue(char[][] board, String word) {
		boolean exist = false;
		for(int i = 0;i < board.length; i++)
			for(int j = 0;j < board[i].length;j++) {
				exist = exist(board,i,j,word,0);
				if(exist)
					return exist;
			}
		
		return false;
    }
	private boolean exist(char[][] board,int col, int row, String word, int index) {
		if(index == word.length()) return true;
        if(col < 0 ||col > board.length - 1 || row < 0 || row > board[col].length - 1) return false;
        if(board[col][row] != word.charAt(index)) return false;
        board[col][row] = '*';
        boolean exist = exist(board,col+1,row,word,index+1) || exist(board,col-1,row,word,index+1) ||exist(board,col,row+1,word,index+1) ||exist(board,col,row-1,word,index+1);
        board[col][row] = word.charAt(index);//一定要记得将标*的位置还原
        return exist;
    }
}
