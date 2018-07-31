import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*#95
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTreeII {
	public List<TreeNode> generateTrees(int n) {
	       if(n == 0) return new ArrayList();
	       return SubTree(1,n);
	    }
	    private List<TreeNode> SubTree(int lo,int hi){
	    		List<TreeNode> list = new ArrayList();
	        if(lo > hi){
	            list.add(null);
	            return list;
	        }
	        if(lo == hi) {
	        		list.add(new TreeNode(lo));
	        		return list;
	        }
	        
	        for(int i = lo;i <= hi;i++) {
	        		List<TreeNode> left = SubTree(lo,i-1);
	        		List<TreeNode> right = SubTree(i+1,hi);
	        		for(TreeNode leftNode : left)
	        			for(TreeNode rightNode : right) {
	        				TreeNode node = new TreeNode(i);
	        				node.left = leftNode;
	        				node.right = rightNode;
	        				list.add(node);
	        			}
	        }
	        
	        return list;
	    }
	
	
}	
