/*#337
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
 */
public class HouseRobberIII {
	//top-down
	public int rob(TreeNode root) {
		if(root == null) return 0;
		int val = 0;
		if(root.left != null)
			val += rob(root.left.left) + rob(root.left.right);
		if(root.right != null)
			val += rob(root.right.left) + rob(root.right.right);
		
		return Math.max(root.val + val, rob(root.left) + rob(root.right));
	}
	/*
	 * In step I, we only considered the aspect of "optimal substructure", but think little about the possibilities of overlapping of the subproblems. 
	 * For example, to obtain rob(root), we need rob(root.left), rob(root.right), rob(root.left.left), rob(root.left.right), rob(root.right.left), rob(root.right.right); 
	 * but to get rob(root.left), we also need rob(root.left.left), rob(root.left.right), similarly for rob(root.right). 
	 * The naive solution above computed these subproblems repeatedly, which resulted in bad time performance. 
	 * Now if you recall the two conditions for dynamic programming: "optimal substructure" + "overlapping of subproblems", we actually have a DP problem. 
	 * A naive way to implement DP here is to use a hash map to record the results for visited subtrees.
	 * 
	 */
	public int rob2(TreeNode root) {
		int[] res = new int[2]; // store the values of two choices: choose root or not
		res = CalSum(root);
		return Math.max(res[0], res[1]);
	}
	public int[] CalSum(TreeNode root) {
		if(root == null) return new int[2];
		
		int[] left = CalSum(root.left);
		int[] right = CalSum(root.right);
		
		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //!!!!important not choose root 
		res[1] = root.val + left[0] + right[0];
		
		return res;
	}
	
	
}
