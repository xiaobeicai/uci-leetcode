/*Description #461
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Input: x = 1, y = 4 Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HanmDistance {
	
	/*普通方法13ms
	 * 注意size的临界判断值是32不是31
	 */
	 public int hammingDistance(int x, int y) {
	        int size = 0;
	        int count = 0;
		 	while(++size < 32) {
		 		if(x%2 != y%2)
		 			count++;
		 		x /= 2;
		 		y /= 2;
		 	}
		 	
		 	return count;
	    }
	 /*位运算 10ms
	  * 提高时间效率
	  * 通过1<<i的方式来排查每一位的值
	  */
	 public int hammingDistance2(int x, int y) {
	        int count = 0;
	        x = x^y; //找出x与y之间不同的地方
		 	for(int i = 0; i< 32; i++) {
		 		if((x & (1<<i)) 	> 0 )
		 			count++;
		 	}
		 	
		 	return count;
	    }
	 
}
