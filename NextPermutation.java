import java.util.Arrays;

/*#31
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {
	//nlogn
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int len = nums.length;
        
        int i = len - 2;
        for(;i >= 0;i--) {
        		if(nums[i] < nums[i+1]) {
        			int index = i+1; //1
        			int min = nums[i+1]; //3
        			for(int j = i+1;j < nums.length;j++)
        				if(nums[j] > nums[i] && nums[j] < min) {
    					min = nums[j];
    					index = j;
        				}
        			
        			nums[index] = nums[i];
        			nums[i] = min;
        			Arrays.sort(nums,i+1,nums.length);
        			break;
        		}
        }
        
        if(i == -1) Arrays.sort(nums);
        return;
    }
	//1.倒着找第一个下降的数字
	//2.从下一个开始找比这个数大的最小的数字
	//3.二者交换
	//4.把下降的数字之后的数逆序排列
	public void nextPermutation2(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int len = nums.length;
        int i = len-2;
        for(;i >= 0;i--)
        		if(nums[i] < nums[i+1]) {
        			for(int j = nums.length - 1;j > i;j--)
        				if(nums[j] > nums[i]) {
        					int temp = nums[j];
        					nums[j] = nums[i];
        					nums[i] = temp;
        					break;
        				}
        			
        			for(int j = i + 1;j < nums.length - j + i;j++) {
        				int temp = nums[j];
        				nums[j] = nums[nums.length - j + i];
        				nums[nums.length - j + i] = temp;
        			}
        			break;		
        		}
        
        if(i == -1) {//corner case
        		for(int k = 0;k < nums.length- 1 -k;k++) {
        			int temp = nums[k];
        			nums[k] = nums[nums.length - 1 - k];
        			nums[nums.length - 1 - k] = temp;
        		}
        }
        return;
    }
}
