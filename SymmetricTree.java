import java.util.LinkedList;
import java.util.Queue;

/*#101 easy
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
	//iterative 迭代
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
        TreeNode left = root.left,right = root.right;
        if(left == null && right == null) return true;
        else {
        	Queue<TreeNode> leftQ = new LinkedList<TreeNode>();
        	Queue<TreeNode> rightQ = new LinkedList<TreeNode>();
        	leftQ.add(left);
        	rightQ.add(right);
        	
        	while(!leftQ.isEmpty() && !rightQ.isEmpty()) {
        		left = leftQ.poll();
        		right = rightQ.poll();
        		if(left == null && right == null) continue;
        		if(left == null || right == null) return false;
        		if(left.val != right.val) return false;
        		leftQ.add(left.left);
        		leftQ.add(left.right);
        		rightQ.add(right.right);
        		rightQ.add(right.left);
        	}
        	
        	if(leftQ.isEmpty() && rightQ.isEmpty()) return true;
        	else return false;
        }
    }
	//recursive 递归
	public boolean isSymmetric2(TreeNode root) {
		if(root == null) return true;
        TreeNode left = root.left,right = root.right;
        return helper(left,right);
        
    }
	public boolean helper(TreeNode left,TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if(left.val != right.val) return false;
		return helper(left.left,right.right) && helper(left.right,right.left);
	}
}
