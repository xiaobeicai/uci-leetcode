import java.util.ArrayList;
import java.util.List;

/*#448
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */
public class FindAllNumDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList();
        if(nums == null || nums.length == 0) return res;
        int len = nums.length;
        for(int i = 0;i < len;i++) {
        		int index = Math.abs(nums[i]) - 1;
        		if(nums[index] > 0)
        			nums[index] = - nums[index];
        }
        
        for(int i = 0;i < len;i++)
        		if(nums[i] > 0)
        			res.add(i+1);
        
        return res;
    }
}
