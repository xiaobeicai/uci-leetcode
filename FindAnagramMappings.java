import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*#760
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * For example, given
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * We should return
 * [1, 4, 3, 2, 0]
 * as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * Note:
 * A, B have equal lengths in range [1, 100].
 * A[i], B[i] are integers in range [0, 10^5].
 */
public class FindAnagramMappings {
	//T~2N S~2N
	public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> mapB = new HashMap<Integer,Integer>();
        int[] res = new int[A.length];
        for(int i = 0;i < A.length;i++) {
        		mapB.put(B[i], i);
        }
        
        for(int i = 0;i < A.length;i++) {
        		int j = mapB.get(A[i]);
        		res[i] = j;
        }
        return res;
    }
	
	//if contains duplicate
	public int[] anagramMappingsContainsDuplicate(int[] A, int[] B) {
        Map<Integer,Queue<Integer>> mapB = new HashMap<Integer,Queue<Integer>>();
        int[] res = new int[A.length];
        for(int i = 0;i < A.length;i++) {
        		int b = B[i];
        		mapB.putIfAbsent(B[i], new LinkedList());
        		mapB.get(B[i]).add(i);
        }
        
        for(int i = 0;i < A.length;i++) {
        		int j = mapB.get(A[i]).poll();
        		res[i] = j;
        }
        return res;
    }
}
