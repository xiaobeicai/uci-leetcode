/*Description:
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * 
 */

/*
 * Space~1 Time~N
 * 3ms
 * 优化：
 * 删除了记录0个数的count、记录第一个非零数的index
 * 删除了跳出循环后给末尾根据0的个数赋值的循环
 */
public class MoveZero {
	//0 1 0 3 12
	//1
	 public void moveZeroes(int[] nums) {
		 int size = nums.length;
		 	int indexZero = 0;
	        for(int i = 0;i < size;i++) {
	        		if(nums[i] == 0)
	        			continue;
	        		else {
	        			nums[indexZero++] = nums[i];
                     if((indexZero-1)< i)
	        			nums[i] = 0;
	        		}
	        }
	        
	    }
}
