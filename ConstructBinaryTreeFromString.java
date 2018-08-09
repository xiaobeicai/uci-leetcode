/*#536 medium
 * You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".
 */
public class ConstructBinaryTreeFromString {
	public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;
        return helper(s,0,s.length() - 1);
    }
	public TreeNode helper(String s,int start,int end) {
		if(start > end || start >= s.length() || end >= s.length()) return null;
		int pos = 1;
		if(s.charAt(start) == '-') {
			pos = -pos;
			start++;
		}
		int res = 0;
		while(start <= end && Character.isDigit(s.charAt(start))) {
			res = res * 10 + s.charAt(start) - '0';
			start++;
		}
		start--;
		
		TreeNode root = new TreeNode(pos * res);
        if(start == end) return root;
		if(s.charAt(start + 1) == '(') {
			int l_end = start + 1,count = 0;
			for(;l_end <= end;l_end++) {
				if(s.charAt(l_end) =='(')
					count++;
				if(s.charAt(l_end) == ')')
					count--;
				if(count == 0)
					break;
			}
			root.left = helper(s,start + 2,l_end - 1);
			root.right = helper(s,l_end + 2,end - 1);
			
			return root;
		}
		else return root;
	}
}
