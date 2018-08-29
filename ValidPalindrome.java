import javax.net.ssl.SSLContext;

import edu.princeton.cs.algs4.StdOut;

/*Description:#125
 * Given a string, determine if it is a palindrome, considering only alphanumeric(字母数字！！！) characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		 char[] clean = new char[s.length()];
			int i = 0;
	        for(char ch: s.toCharArray()) {
	        		if((ch >='a' && ch <= 'z') || (ch >='A' && ch <='Z') ||(ch >='0' && ch <='9') )
	        			clean[i++] = ch;
	        }
	        int size = i;
	        for(i = 0; i < size/2 ;i++) {
	        	//字符可用==比较，字符串不行，因为在字符串中==表示地址相同，eaual才表示字符串内容相同
	        	//注意大小写判断为一样 不可直接根据 'A'-'a'来计算，因为不知道被测字符是大写还是小写，乱加会算成别的 例如 P(80) + A(65) - a(97) = 0(48)
	        		if(clean[i] != clean[size - 1 - i]) {
	        			if(clean[i] >= 'a' && clean[i] <= 'z' && (clean[i] + 'A' - 'a' == clean[size-1-i]))
	        				continue;
	        			if(clean[i] >= 'A' && clean[i] <= 'Z' && (clean[i] + 'a' - 'A' == clean[size-1-i]))
        					continue;
	        			return false;
	        		}
	        }
	        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {2,7,11,15};
		//int target = 9;
		String res = "TRUE";
		if(!isPalindrome("0P"))
			res = "FALSE";
        	StdOut.print("result:" + res);

	}
}
