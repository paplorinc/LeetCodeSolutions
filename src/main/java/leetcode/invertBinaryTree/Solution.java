package leetcode.invertBinaryTree;

import leetcode.TreeNode;

/**
 * Invert a binary tree.
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

 * Source: https://leetcode.com/problems/invert-binary-tree/
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
    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) return null;
    //     else {
    //         TreeNode left = root.left;
    //         root.left = invertTree(root.right);
    //         root.right = invertTree(left);
    //         return root;
    //     }
    // }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        else {
            TreeNode node = new TreeNode(root.val);
            node.left = invertTree(root.right);
            node.right = invertTree(root.left);
            return node;
        }
    }
}
