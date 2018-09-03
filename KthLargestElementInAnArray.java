import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*#215
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
	//T~N(N2) S~1
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;
        shuffle(nums);
        while(lo < hi) {
        		int j = partition(nums,lo,hi);
        		if(j < k) lo = j + 1;
        		else if(j > k) hi = j - 1;
        		else break;
        }
        return nums[k];
    }
	
	private int partition(int[] nums,int lo,int hi) {
		int i = lo,j = hi+1;
		while(true) {
			while(less(nums[++i],nums[lo]))
				if(i == hi)
					break;
			while(less(nums[lo],nums[--j]))
				if(j == lo)
					break;
			if(i >= j) break;
			swap(nums,i,j);
		}
		swap(nums,lo,j);
		return j;
	}
	private boolean less(int i,int j) {
		return i < j;
	}
	
	private void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	//optimized gurranted T~N
	private void shuffle(int[] nums) {
		Random r = new Random();
		for(int i = 0;i < nums.length;i++) {
			int j = r.nextInt(i + 1);
			swap(nums,i,j);
		}
	}
}
