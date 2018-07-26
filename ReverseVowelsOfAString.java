import java.util.HashSet;
import java.util.Set;

/*#345
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		char[] list = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int i = 0, j = s.length() - 1;
        while(i < j) {
        		while(!set.contains(list[i]) && i < j)
        			i++;
        		while(!set.contains(list[j]) && i < j)
        			j--;
        		if(i < j) {
        			char temp = list[i];
        			list[i] = list[j];
        			list[j] = temp;
        			i++;
        			j--;
        		}
        }
        
        return new String(list);
    }
}
