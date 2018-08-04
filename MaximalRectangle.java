import java.util.Stack;

/*#85 hard
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null) return 0;
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0 ) return 0;
        
        int max = 0;
        int[] height = new int[n];
        for(int i = 0;i < m;i++) {
        		for(int j = 0;j < n;j++)
        			height[j] = matrix[i][j] == '0' ? 0:(height[j] + 1);
        		max = Math.max(max, largestRectangleArea2(height));
        }
        	return max;
    }
	
	public int largestRectangleArea2(int[] heights) {
		int len = heights.length;
        int maxArea = 0;
        Stack<Integer> s  = new Stack<Integer>();
        int[] h = new int[heights.length + 1];
        for(int i = 0;i < heights.length;i++)
        		h[i] = heights[i];
        h[heights.length] = 0;
        for(int i = 0;i < len + 1;i++) {
        		if(s.isEmpty() || h[s.peek()] <= h[i]) {
        			s.push(i);
        		}
        		else {
        			int cur = s.pop();
        			int dis = h[cur];
        			maxArea = Math.max(maxArea, dis * (s.isEmpty() ? i : i - s.peek() - 1));
        			--i;
        		}
        }
        
        return maxArea;
    }
}
