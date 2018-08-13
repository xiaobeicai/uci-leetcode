/*Description#11
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant（倾斜） the container and n is at least 2.
 */
public class ContainerWithMostWater {
	
	/*test;
	 *1,0;0,1,0;1,2,1;1,2,4,3（理解题意：短板效应）
	 */
	/*超时 T~N2 S~1
	 * 
	 */
	public int maxArea(int[] height) {
		int size =height.length;
		int max = 0;
		for(int i = 0;i < size-1;i++) {
			if(height[i] != 0)
			for(int j = i+1;j < size;j++) {
				if(height[j] !=0) {
					int temp = Math.min(height[i], height[j])*(j-i); //短板效应
					if(max < temp)
						max = temp;
				}
					
			}
		}
		return max;
    }
	/*Two Pointer Approach
	 * 
	 */
	public int maxArea2(int[] height) {
		int size = height.length;
		int max = 0;
		int i = 0, j = size - 1;
		int area;
		while(i < j) {
			if(height[i] < height[j]) {
				area = height[i] * (j - i);
				i++;
				}
			else {
				area = height[j] * (j - i);
				j--;
			}	
			if(max < area)
				max = area;
		}
		return max;		
        	
    }
}
