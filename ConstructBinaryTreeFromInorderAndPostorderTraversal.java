/*#106 medium
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        return helper(postorder.length - 1,0,inorder.length - 1,inorder,postorder);
    }
	
	public TreeNode helper(int poststart,int instart,int inend,int[] inorder,int[] postorder) {
		if(poststart == postorder.length || instart > inend) return null;
		
		TreeNode root = new TreeNode(postorder[poststart]);
		int inIndex = instart;
		//find the root in inOrder  left-in:(0,inIndex-1) right-in:(inIndex + 1,inend)
		for(;inIndex <= inend;inIndex++)
			if(inorder[inIndex] == root.val)
				break;
		//set the root.left and right
		root.left = helper(poststart - (inend - inIndex) - 1,instart,inIndex - 1,inorder,postorder);
		root.right = helper(poststart - 1,inIndex + 1,inend,inorder,postorder);
		
		return root;
	}
}
