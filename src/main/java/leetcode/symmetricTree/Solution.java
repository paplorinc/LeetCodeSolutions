package leetcode.symmetricTree;

import leetcode.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 
 * But the following [1,2,2,null,3,null,3]  is not:
 * 
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * Source: https://leetcode.com/problems/symmetric-tree/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        else return root1 != null && root2 != null
                 && root1.val == root2.val
                 && isSymmetric(root1.left, root2.right)
                 && isSymmetric(root1.right, root2.left);
    }
}
