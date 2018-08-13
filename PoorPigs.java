/*#458
 * 
 */
public class PoorPigs {
public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int num = minutesToTest/minutesToDie + 1;   //算出有几轮
		double  res = Math.log(buckets)/Math.log(num); //loga(b) = ln(b)/ln(a);
		return (int)Math.ceil(res); //cell取大于该数的最小整数
    }
	
}
