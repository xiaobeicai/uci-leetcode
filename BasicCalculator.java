import java.util.Stack;

/*#224 hard
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */
public class BasicCalculator {
	public int calculate(String s) {
		if(s == null ||s.length() == 0)return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0, sign = 1,num = 0;
        for(int i = 0;i < s.length();i++) {
        		char ch =s.charAt(i);
        		if(Character.isDigit(ch)) {
        			num = num * 10 + s.charAt(i) - '0';
        		}
        		else if(ch == '+') {
        			res += num * sign;
        			num = 0;
        			sign = 1;
        		}
        		else if(ch == '-') {
        			res += num * sign;
        			num = 0;
        			sign = -1;
        		}
        		else if(ch == '(') {
        			stack.push(res);
        			stack.push(sign);
        			res = 0;
        			sign = 1;
        		}
        		else if(ch == ')'){
        			res += num * sign;
        			res *= stack.pop();
        			res += stack.pop();
        			num = 0;
        		}
        }
        return res + num * sign;
        
    }
	
	
}
