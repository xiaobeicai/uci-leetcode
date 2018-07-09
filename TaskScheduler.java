import java.util.Arrays;

/*#621
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */
public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		if(tasks == null || tasks.length == 0) return 0;
		
		int len = tasks.length; //corner case
        int[] map = new int[26];
        for(char ch :tasks)
        		map[ch - 'A']++;
        
        	Arrays.sort(map);
        	int max = map[25];
        	int i = 25;
        	for(;i >= 0;i--)
        		if(map[i] != map[25])
        			break;
        	
        	return Math.max(len,(max - 1) * (n + 1) + 25 - i);
        	
    }
}
