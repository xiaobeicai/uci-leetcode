/*Description:#326
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if(n == 0 || n == 1 || n == 2) return false; //corner case:0,1
		if(n == 3) return true;
        return (n%3  == 0) && isPowerOfThree(n/3);
    }
}
