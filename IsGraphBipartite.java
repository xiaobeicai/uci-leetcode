import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import edu.princeton.cs.algs4.StdOut;

/*#785
 * Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
 

Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */
public class IsGraphBipartite {
	public static boolean isBipartite(int[][] graph) {
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        q1.add(0);
        s1.add(0);
        do{
        		while(!q1.isEmpty()) {
        			int index = q1.poll();
                	for(int i = 0;i < graph[index].length;i++) {
                		int key = graph[index][i];
                		if(!s2.contains(key)) {
                			if(s1.contains(key)) return false;
                			q2.add(key);
                			s2.add(key);
                		}
                	}
        		}
        		while(!q2.isEmpty()) {
        			int index2 = q2.poll();
        			for(int i = 0;i < graph[index2].length;i++) {
        				int key = graph[index2][i];
        				if(!s1.contains(key)) {
        					if(s2.contains(key)) return false;
        					s1.add(key);
        					q1.add(key);
        				}
        			}
        		}
        }while(q1.isEmpty() || !q2.isEmpty());
        return true;
    }
	
	public boolean isBipartite2(int[][] graph) {
		int[] colors = new int[graph.length];
		Arrays.fill(colors, -1);
		int color = 0;
		for(int i = 0;i < graph.length;i++) {
			if(!validColor(graph,colors,color,i))
				return false;
		}
		return true;
	}
	
	private boolean validColor(int[][] graph, int[] colors,int color, int i) {
		if(colors[i] == -1) {
			colors[i] = color;
			for(int next : graph[i]) {
				if(!validColor(graph,colors,color,next));
					return false;
			}
			return true;
		}
		else {
			return colors[i] == color;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
		boolean res = isBipartite(graph);
        	StdOut.print("result:" + res);
	}
}
