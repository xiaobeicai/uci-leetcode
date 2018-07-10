/*#42
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
	//DP
	public int trap(int[] height) {
		int size = height.length;
		if(size == 0) return 0;
		int[] left_max = new int[size];
		int[] right_max = new int[size];
		int sum = 0;
		left_max[0] = height[0];
		for(int i = 1;i < size;i++)
			left_max[i] = Math.max(height[i], left_max[i-1]);
			
		right_max[size-1] = height[size - 1];
		for(int i = size - 2;i >= 0;i--)
			right_max[i] = Math.max(height[i], right_max[i + 1]);
		
		for(int i = 0;i < size;i++)
			sum += Math.min(left_max[i], right_max[i]) - height[i];
		
		return sum;
        
    }
}
