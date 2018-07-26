import java.util.ArrayList;
import java.util.List;

/*#249
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		boolean[] memo = new boolean[strings.length];
		List<List<String>> res = new ArrayList();
        for(int i = 0;i < strings.length;i++) {
        		if(!memo[i]) {
        			memo[i] = true;
        			List<String> list = new ArrayList<String>();
        			list.add(strings[i]);
        			
        			for(int j = i + 1;j < strings.length;j++) {
        				if(!memo[j]) {
        					if(isShiftedSeq(strings[i],strings[j])) {
        						memo[j] = true;
        						list.add(strings[j]);
        					}
        					
        				}
        			}
        			res.add(list);
        		}
        	}
        
        return res; 
    }
	
	public boolean isShiftedSeq(String s1, String s2) {
		if(s1.length() == s2.length()) {
			if(s1.length() == 1)
				return true;
			else {
				for(int i = 0;i < s1.length() - 1;i++) {
					//attention to the minus
					int comp1 = (s1.charAt(i) - 'a') - (s1.charAt(i+1) - 'a');//0 - 25
					int comp2 = (s2.charAt(i) - 'a') - (s2.charAt(i+1) - 'a'); //1 - 0 
					if((comp1 - comp2)%26 != 0) return false;
				}
				return true;
			}
		}
		return false;
	}
}
