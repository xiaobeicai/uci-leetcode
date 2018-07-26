/*Description:#110
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */

public class BalanceBinaryTree {
	/*做的很慢
	 * 
	 */
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 public boolean isBalanced(TreeNode root) {
		 	
		 	int res = TreeHeight(root);
	        return res >=0;
	    }
	 
	 private int TreeHeight(TreeNode node) {
		 if(node == null) return 0;
		 int left = TreeHeight(node.left) + 1;
		 int right = TreeHeight(node.right) + 1;
		 
		 if(left < 0 || right < 0||Math.abs(left - right) > 1) 
			return -99;
		 
		 return Math.max(left, right);
	 }
	 
	 /*Improvement 两个递归、双循环
	  * 
	  */
	 public boolean isBalanced2(TreeNode root) {
		 	if(root == null) return true;
		 	int left = depth(root.left) + 1;
		 	int right = depth(root.right) + 1;
		 	
		 	return Math.abs(left-right) <=1 && isBalanced2(root.left) && isBalanced2(root.right);
		 	
	    }
	 
	 private int depth(TreeNode node) {
		 if(node == null) return 0;
		 int left = depth(node.left) + 1;
		 int right = depth(node.right) + 1;
		 
		 return Math.max(left, right);
	 }
}
