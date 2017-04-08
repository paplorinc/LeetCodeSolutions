package leetcode.minimumDepthofBinaryTree;

import leetcode.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 * Source: https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
   public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null || root.right == null) return 1 + minDepth(root.left) + minDepth(root.right);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
