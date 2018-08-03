import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

public class ExcelSheetColumnNumber {
	/*HashTable 慢 10ms
	 *注意只有char能进行加减
	 *String会出问题
	 */
	public static int titleToNumber(String s) {

		Map<Character,Integer> map = new HashMap<>();
		 for(int i = 0;i < 26;i++)
     		map.put((char)('A'+i), i+1);
		 
        	int size = s.length();
        	int num = 0;
        	
        for(int i = 0;i < size;i++) {
        		int val = map.get(s.charAt(i));
        		num = num * 26 + val;
        }
        return num;
    }
/*5ms
 * 
 */
	public static int titleToNumber2(String s) {
        
		int size = s.length();
        	int num = 0;
        	
        for(int i = 0;i < size;i++) {
        		int val = s.charAt(i) - 'A' + 1;
        		num = num * 26 + val;
        }
        return num;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = titleToNumber("BA");
        	StdOut.print("result:" + res);

	}
}
