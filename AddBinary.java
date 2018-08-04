/*Description:#67
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *  00
 */
public class AddBinary {
	//用%2计算各位
	public String addBinary(String a, String b) {
		int sum = 0,carry = 0;
		StringBuilder sb = new StringBuilder();
		int i = a.length()-1,j = b.length()-1;
		while(i >= 0 || j>= 0) {
			sum = carry;
			if(i >= 0) sum += a.charAt(i--) - '0';
			if(j >= 0) sum += b.charAt(j--) - '0';
			sb.append(sum%2);
			carry = sum/2;
		}
		if(carry == 1) sb.append(1);
		return sb.reverse().toString();
    }
	
	public String addBinaryXOR(String a, String b) {
		int res = 0,carry = 0;
		StringBuilder sb = new StringBuilder();
		int i = a.length()-1,j = b.length()-1;
		int aByte = 0, bByte = 0;
		while(i >= 0 || j>= 0) {
			aByte = (i >= 0)? Character.getNumericValue(a.charAt(i--)):0;
			bByte = (j >= 0)? Character.getNumericValue(b.charAt(j--)):0;
			res = aByte ^ bByte ^ carry;
			sb.append(res);
			carry = (aByte + bByte + carry) >=2 ? 1:0;
		}
		if(carry == 1) sb.append(carry);
		return sb.reverse().toString();
    }
}
