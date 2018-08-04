import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdOut;

/*#241
 * Given a string of numbers and operators, return all possible results from computing all the 
 * different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

 */
public class DifferentWaysToAddParentheses {
	public static List<Integer> diffWaysToCompute(String input) {
		int len = input.length();
	       List<Integer> list = new ArrayList();
	      if(input == null || len == 0) return list;
	      
	       //corner case 11 没有符号
	       for(int i = 0;i < len;i++) {
	    	   	if(input.charAt(i) == '+' ||input.charAt(i) == '-' || input.charAt(i) == '*') {
	    	   		List<Integer> left = diffWaysToCompute(input.substring(0, i));
	    	   		List<Integer> right = diffWaysToCompute(input.substring(i+1,len));
	    	   		for(int j = 0;j < left.size();j++)
	    	   			for(int k = 0;k < right.size();k++) {
	    	   				int l = left.get(j), r = right.get(k),sum = 0;
	    	   				
	    	   				switch(input.charAt(i)) {
	    	   					case '+':
	    	   						sum = l + r;
	    	   						break; //写switch 语句忘记break
	    	   					case '-':
	    	   						sum = l - r;
	    	   						break;
	    	   					case '*':
	    	   						sum = l * r;
	    	   						break;
	    	   				}
	    	   				list.add(sum);
	    	   			}
	    	   		}
	       }
	       if(list.size() == 0) list.add(Integer.valueOf(input)); //don't forget the situation that only contains number!
	       return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2-1-1";
		List<Integer> res = diffWaysToCompute(str);
        	StdOut.print("result:" + res);

	}
}
