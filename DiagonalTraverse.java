/*#498
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		//right-up and left-down
		if(matrix == null) return new int[]{};
		int m = matrix.length;
		if(m == 0) return new int[]{};
		int n = matrix[0].length;
		if(n == 0) return new int[]{};
		
		int[][] move = {{-1,1},{1,-1}};
		int[] res = new int[m * n];
		int r = 0,c = 0,k = 0;
		for(int i = 0;i < m * n;i++) {
			res[i] = matrix[r][c];
			r += move[k][0];
			c += move[k][1];
			
			if(r >= m) {r--;c += 2; k = 1-k;}
			if(c >= n) {c--;r += 2; k = 1-k;}
			if(r < 0) {r++; k = 1-k;}
			if(c < 0) {c++; k = 1-k;}
		}
		return res; 
    }
}
