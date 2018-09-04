import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*#433
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), 
 * where ONE mutation is defined as ONE single character changed in the gene string.
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. 
 * A gene must be in the bank to make it a valid gene string.
 * Now, given 3 things - start, end, bank, 
 * your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". 
 * If there is no such a mutation, return -1.
 * Note:
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1
Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2
Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
 */
public class MinimumGeneticMutation {
	private int min = Integer.MAX_VALUE;
	public int minMutation(String start, String end, String[] bank) {
        if(start == null || end == null || bank == null || start.length() == 0 || end.length() == 0 || bank.length == 0)
        		return -1;
        Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        Map<String,Boolean> used = new HashMap<String,Boolean>();

        map.put(start, new ArrayList<String>());
        for(int i = 0;i < bank.length;i++) {
        		if(!map.containsKey(bank[i])) 
        			map.put(bank[i], new ArrayList<String>());
        		used.put(bank[i], false);
        }
       
        for(int j = 0;j < bank.length;j++) {
        		if(canChange(start,bank[j]))
        			map.get(start).add(bank[j]);
        }
        
        for(int i = 0;i < bank.length;i++) {
        		for(int j = 0;j < bank.length;j++)
        			if(canChange(bank[i],bank[j]))
        				map.get(bank[i]).add(bank[j]);
        }
        
        helper(start,end,bank,map,used,0);
        return min == Integer.MAX_VALUE? -1:min;
    }
	
	public void helper(String start,String end,String[] bank,Map<String,ArrayList<String>> map,Map<String,Boolean> used,int count) {
		if(start.equals(end)) min = Math.min(min, count);
		if(count >= min) return;
		ArrayList<String> list = map.get(start);
		for(int i = 0;i < list.size();i++) {
			String str = list.get(i);
			if(!used.get(str)) {
				used.replace(str, true);
				helper(list.get(i),end,bank,map,used,count+1);
				used.replace(str, false);
			}
		}
	}
	
	public boolean canChange(String start,String end) {
		int count = 0;
		for(int i = 0;i < 8;i++)
			if(start.charAt(i) != end.charAt(i))
				count++;
		return count == 1;
	}
}
