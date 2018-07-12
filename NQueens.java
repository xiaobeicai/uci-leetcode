import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdOut;

/*#51
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack 
 * each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
	public static List<List<String>> solveNQueens(int n) {
		
		List<List<String>> res = new ArrayList<List<String>>();
        if(n == 0) return res;
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++) 
        		for(int j = 0;j < n;j++)
        			board[i][j] = '.';
        
        dfs(res,board,0,n);
        return res;
    }
	
	private static void dfs(List<List<String>> res,char[][] board,int index,int n){
		if(index == n) {
			res.add(construct(board));
			return;
		}
		
		for(int j = 0;j < n;j++) {
			if(isSafe(board,index,j,n)) {
				board[index][j] = 'Q';
				dfs(res,board,index+1,n);
				board[index][j] = '.';
			}
		}
		return;
		
		
	}
	
	private static boolean isSafe(char[][] board, int row, int col,int n) {
		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++) {
				if(board[i][j] == 'Q' && ((row + j == col + i) ||(row + col == i + j) || (row == i) || (col == j))) //大括号不能漏
					return false;
			}
		return true;
	}
	
	private static List<String> construct(char[][] board){
		List<String> list = new ArrayList<String>();
		for(int i = 0;i < board.length;i++){
				String s = new String(board[i]);
				list.add(s);
			}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        	StdOut.print("result:" + solveNQueens(4));

	}
}

