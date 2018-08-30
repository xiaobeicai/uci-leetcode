import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import edu.princeton.cs.algs4.StdOut;

/*#721 medium
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, 
 * and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. 
Note that even if two accounts have the same name, they may belong to different people as people could have the same name. 
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, 
and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 */
public class AccountsMerge {
public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> res = new ArrayList();
        if(accounts == null) return res;
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        
        for(int i = 0;i < accounts.size();i++) {
        		List<String> list = accounts.get(i);
        		for(int j = 1;j < list.size();j++) {
        			if(!map.containsKey(list.get(j))) {
        				List<Integer> ids = new ArrayList();
        				ids.add(i);
        				map.put(list.get(j), ids);
        			}
        			else map.get(list.get(j)).add(i);
        		}
        }
        boolean[] memo = new boolean[accounts.size()];
        for(int i = 0;i < accounts.size();i++) {
        		if(!memo[i]) {
        			Queue<Integer> ids = new LinkedList();
        			ids.add(i);
        			Set<String> mails = new HashSet<String>();
        			while(!ids.isEmpty()) {
        				int id = ids.poll();
        				if(!memo[id]) {
        					memo[id] = true;
        					List<String> list = accounts.get(id);
        					for(int j = 1;j < list.size();j++) {
        						String email = list.get(j);
        						mails.add(email);
        						if(map.containsKey(email)) {
        							List<Integer> temp = map.get(email);
        							for(int k = 0;k < temp.size();k++) 
        								if(!memo[temp.get(k)]) 
        									ids.add(temp.get(k));
        						}
        					}
        				}
        			}
        			List<String> sum = new ArrayList(mails);
        			Collections.sort(sum);
        			List<String> sublist = new ArrayList();
        			sublist.add(accounts.get(i).get(0));
        			sublist.addAll(sum);
        			res.add(sublist);
        		}
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> accounts = new ArrayList();
		List<String> john = new ArrayList();
		john.add("John");
		john.add("johnsmith@mail.com");
		john.add("john_newyork@mail.com");
		List<String> john2 = new ArrayList();
		john2.add("John");
		john2.add("johnsmith@mail.com");
		john2.add("john00@mail.com");
		List<String> Mary = new ArrayList();
		Mary.add("Mary");
		Mary.add("mary@mail.com");
		List<String> john3 = new ArrayList();
		john3.add("John");
		john3.add("johnnybravo@mail.com");
		accounts.add(john);
		accounts.add(john2);
		accounts.add(Mary);
		accounts.add(john3);		
		List<List<String>> res = accountsMerge(accounts);
    		StdOut.print("result:" + res);
	}
//
}
