/*#124
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */


public class BinaryTreeMaxPathSum {
	
	private class ResultType{
		int root2any,any2any;
		
		ResultType(int root2any,int any2any){
			this.root2any = root2any;
			this.any2any = any2any;
		}
	}
	//any2any
	public int maxPathSum(TreeNode root) {
		ResultType res = helper(root);
		return Math.max(res.any2any, res.root2any);
    }
	
	//any2any function
	//1、2: left:any2any right:any2any
	//3: leftroot2any + root + rightroot2any
	private ResultType helper(TreeNode root) {
        	if(root == null) return new ResultType(Integer.MIN_VALUE,Integer.MIN_VALUE);
        	//divide
		ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        	//conquer
        int root2any = root.val + Math.max(0, Math.max(left.root2any, right.root2any));
        
        int any2any = Math.max(left.any2any, right.any2any);
        any2any = Math.max(any2any, Math.max(left.root2any, 0) + root.val + Math.max(right.root2any, 0));
        
        return new ResultType(root2any,any2any); 
        
	}
}
