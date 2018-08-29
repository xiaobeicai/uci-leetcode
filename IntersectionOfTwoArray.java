import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*#349
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArray {
	//T~N S~2N
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList();
        for(int i = 0;i < nums1.length;i++) {
        	if(!set.contains(nums1[i]))
        		set.add(nums1[i]);
        }
        for(int i = 0;i < nums2.length;i++)
        		if(set.contains(nums2[i]) && !list.contains(nums2[i]))
        			list.add(nums2[i]);
        
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++)
        		res[i] = list.get(i);
        		
        return res;
    }
}
