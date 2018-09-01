/*#543
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
	private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        MaxDepth(root);
        return max;
    }
    public int MaxDepth(TreeNode root) {
    	 if(root == null) return 0;
    	 
    	 int left = MaxDepth(root.left);
    	 int right = MaxDepth(root.right);
    	 
    	 max = Math.max(max,left + right);
    	 
    	 return left + right + 1;
    }
}
