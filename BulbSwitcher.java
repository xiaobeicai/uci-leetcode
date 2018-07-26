/*#319
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * Example:
 * Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 */

public class BulbSwitcher {
/* 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
 * 2,4,6,8,10,12,14,16,18,20,
 * 3,6,9,12,15,18,
 * 4,8,12,16,20,
 * 5,10,15,20,
 * 6,12,18,
 * 7,14,
 * 8,16,
 * 9,18,
 * 10,20,
 * 11,
 * 12,
 * 13,
 * 14,
 * 15,
 * 16,
 * 17,
 * 18,
 * 19,
 * 20,
 * This is a Symmetric Matrices, so only the diagonal elements will be visited odd. 
 * 1,4,16,
 * 16: 1,16,2,8,4
 * 4:1,4,2
 * So the number should be sqrt(n)
 */
	public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
