/*#96
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * G(n): the number of unique BST for a sequence of length n.
 * F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST,
 *  and the sequence ranges from 1 to n.
 *  G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
 *  F(i, n) = G(i-1) * G(n-i)	1 <= i <= n  !!!!!!!!!!!    F(1,3) = G(0) * G(2)   F(2,8) = G(1) * G(6) (G(6)等同于任意6个连续的数字排列组合的可能性)
 *  选取一个结点为根，就把结点切成左右子树，以这个结点为根的可行二叉树数量就是左右子树可行二叉树数量的乘积
 *  G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
 */
public class UniqueBinarySearchTree {
	public int numTrees(int n) {
      int[] G = new int[n + 1];
      G[0] = 1;
      G[1] = 1;
      for(int i = 2;i <= n;i++) { //n
    	  	for(int j = 0;j < i;j++) {
    	  		G[i] += G[j] * G[i - j - 1];
    	  	}
      }
    	 return G[n];
    }
}
