import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

/*Desscription:#17
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class LetterCombinationOfPhoneNumber {
	static String[] nums = {null,null,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static String digits;
	static List<String> list;
	public static List<String> letterCombinations(String d) {
		list = new ArrayList();
		if(d.length() == 0) return list;
        digits = d; 
        String str = new String();
        Digit(str,0);
        return list;
    }
	//如果该参数需要进行变动储存，不能把引用类型作为参数，eg. StringBuilder
	private static void Digit(String str, int i) {  
		if(i == digits.length()) {
			list.add(str);
			return;
		}
		int index = digits.charAt(i) - '0' ;
		
		for(int j = 0;j < nums[index].length();j++){
			char ch = nums[index].charAt(j);
			//String s = str.concat(Character.toString(ch)); 或者直接传s
			Digit(str + Character.toString(ch),i+1); //str = str.concat(ch); digit(ctr,i+1);不可行，因为传进去的参数会改变
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2";
		List<String> list = letterCombinations(s);
        	StdOut.print("result:" + list);

	}
}
