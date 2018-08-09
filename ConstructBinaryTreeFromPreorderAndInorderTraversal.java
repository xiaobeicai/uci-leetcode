/*#105 medium
 * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
        		return null;
        int root_val = preorder[0];
        TreeNode root = new TreeNode(root_val);
        int left_len = 0, len = inorder.length;// 1 5
        for(;left_len< len;left_len++)
        		if(root_val == inorder[left_len])
        			break;
        
        int right_len = len - left_len - 1; //3
        int[] left_inorder = new int[left_len];
        for(int j = 0;j < left_len;j++)
        		left_inorder[j] = inorder[j];
        
        int[] right_inorder = new int[right_len];
        for(int j = 0;j < right_len;j++)
        		right_inorder[j] = inorder[1 + left_len + j];
        
        int[] left_preorder = new int[left_len];
        for(int j = 0;j < left_len;j++)
        		left_preorder[j] = preorder[1+j];
        
        int[] right_preorder = new int[right_len];
        for(int j = 0;j < right_len;j++)
        		right_preorder[j] = preorder[1 + left_len + j];
        
        root.left = buildTree(left_preorder,left_inorder);
        root.right = buildTree(right_preorder,right_inorder);
        
        return root;
    }
	
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
       if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
    	    return null;
       return helper(0,0,inorder.length - 1,preorder,inorder);
    }
	
	public TreeNode helper(int prestart,int instart,int inend,int[] preorder, int[] inorder) {
	       if(prestart == preorder.length || instart > inend) return null;
	       
	       TreeNode root = new TreeNode(preorder[prestart]);
	       int inIndex = instart;
	       for(;inIndex <= inend;inIndex++)
	    	   	if(root.val == inorder[inIndex])
	    	   		break;
	       
	       root.left = helper(prestart + 1,instart,inIndex-1,preorder,inorder);
	       root.right = helper(prestart + inIndex - instart + 1,inIndex + 1,inend,preorder,inorder);
	       return root;
    }
}
