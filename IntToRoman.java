/*#12
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntToRoman {
	public String intToRoman(int num) { //29%
		String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] res= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < res.length;i++) {
        		int count = num/res[i];
        		int temp = count;
        		while(temp != 0) {
        			sb.append(str[i]);
        			temp--;
        		}
            num -= count * res[i];
            if(num == 0)
            	break;
        }
        return sb.toString();
    }
	/*代码简练版
	 * 
	 */
	public String intToRoman2(int num) { //79%
		String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] res= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < res.length;i++) {
        		while(num >= res[i]) {
        			sb.append(str[i]);
        			num -= res[i];
        		}
        }
        return sb.toString();
    }
}
