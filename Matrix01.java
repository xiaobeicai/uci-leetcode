import java.util.LinkedList;
import java.util.Queue;

/*#542
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */
public class Matrix01 {
	public int[][] updateMatrix(int[][] matrix) {
       int m = matrix.length, n = matrix[0].length;
       if(matrix == null || m == 0 || n == 0) return null;
       Queue<int[]> queue = new LinkedList<int[]>();
       for(int i = 0;i < m;i++)
    	   	for(int j = 0;j < n;j++) {
    	   		if(matrix[i][j] == 0) 
    	   			queue.offer(new int[] {i,j});
    	   		else matrix[i][j] = Integer.MAX_VALUE;
    	   	}
       
       int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
       
       while(!queue.isEmpty()) {
    	   	int[] cell = queue.poll();
    	   	
    	   	for(int[] dir : dirs) {
			int r = cell[0] + dir[0];
    	   		int c = cell[1] + dir[1];
    	   		if(r >= 0 && r < m && c >= 0 && c < n) {
    	   			if(matrix[r][c] == Integer.MAX_VALUE) {
    	   				matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
        	   			queue.add(new int[] {r,c});
    	   			}
    	   			else matrix[r][c] = Math.min(matrix[cell[0]][cell[1]] + 1,matrix[r][c]);
    	   		}
    	   	}
       }
       
       return matrix;
    }
}
