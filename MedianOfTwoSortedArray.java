/*#4
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 
 * Li = (Ci-1)/2 
 * Ri = Ci/2
 */
public class MedianOfTwoSortedArray {
	/*Divide and Conquer T~log(min(m,n))
	 *
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 	int m = nums1.length,n = nums2.length;
	        if(m > n) return findMedianSortedArrays(nums2,nums1); //ensure the shorter one is nums1
	        else{
	        int c1,c2,L1 = 0,L2 = 0,R1 = 0,R2 = 0,lo = 0, hi = 2*m; //add virtual # so the length is 2m   #1#4#7#9#   #1#2#3#
	        
	        while(lo <= hi) {//divide and conquer
	        		c1 = (lo + hi)/2;//1
	        		c2 = n + m - c1;//2
	        		L1 = (c1 == 0)?Integer.MIN_VALUE:nums1[(c1-1)/2];//2
	        		L2 = (c2 == 0)?Integer.MIN_VALUE:nums2[(c2-1)/2];//1
	        		R1 = (c1 == 2*m)?Integer.MAX_VALUE:nums1[c1/2];//2
	        		R2 = (c2 == 2*n)?Integer.MAX_VALUE:nums2[c2/2];//3
	        		
	        		if(L1 > R2) hi = c1-1;
	        		else if(L2 > R1) lo = c1+1;
	        		else break;
	        }
	            
	        return (Integer.max(L1, L2) + Integer.min(R1, R2))/2.0;
	    }
    }
	
	public static void main(String[] args) {
		
	}
}
