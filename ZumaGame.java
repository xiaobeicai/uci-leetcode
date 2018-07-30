/*#448
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.
 * Examples:
 * Input: "WRRBBW", "RB"
 * Output: -1
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 * Input: "WWRRBBWW", "WRBRW"
 * Output: 2
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * Input:"G", "GGGGG"
 * Output: 2
 * Explanation: G -> G[G] -> GG[G] -> empty 
 * Input: "RBYYBBRRB", "YRBGB"
 * Output: 3
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty 
 * Note:
 * You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
 * The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
 * The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
 * Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 */
public class ZumaGame {
	static int maxball = 6;
	public static int findMinStep(String board, String hand) {
        int[] alp = new int[26];
        for(int i = 0;i < hand.length();i++) alp[hand.charAt(i) - 'A']++;
        int res = help(board+"#",alp);
        return res == maxball?-1:res;
        
    }
	private static int help(String board, int[] alp) {
		board = removeSameColorBall(board);
		if(board.length() == 0) return 0;
		int res = maxball;
		for(int i = 0, j = 1;j < board.length();j++) {
			if(board.charAt(i) == board.charAt(j)) continue;
			else {
				int need = 3-(j-i);
				if(need <= alp[board.charAt(i) - 'A']) {
					alp[board.charAt(i) - 'A'] -= need;
					res = Math.min(res, need + help(board.substring(0, i) + board.substring(j),alp));
					alp[board.charAt(i) - 'A'] += need; //从头来过，需要将之前减掉的加上，因为不同的消除次序会决定球使用的数量，并不是唯一解；
				}
				i = j;
			}
		}
		return res;
	}
	private static String removeSameColorBall(String board) {
		if(board.length() == 1) return new String();
		for(int i = 0,j = 0;j < board.length();j++) {
			if(board.charAt(i) == board.charAt(j)) continue;
			else if(j - i >= 3) {
				return removeSameColorBall(board.substring(0, i) + board.substring(j));
			}
			i = j;
		}
		return board;
	}
	
	public static void main(String[] args) {
		String board1  = "WRRBBW";
		String hand1 = "RB";
		String board2  = "WWRRBBWW";
		String hand2 = "WRBRW";
		//int res1 = findMinStep(board1,hand1);
		int res2 = findMinStep(board2,hand2);
		//System.out.println("res1:"+res1);
		System.out.println("res2:"+res2);
		
	}
}
