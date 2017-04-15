package leetcode.deleteNodeinaBST;

import leetcode.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * Example:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 * Another valid answer is [5,2,6,null,4,null,7].
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * Source: https://leetcode.com/problems/delete-node-in-a-bst/
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root != null) {
            TreeNode left = root.left, right = root.right;
            if (key == root.val) {
                if (right == null) return left;
                else {
                    addMin(right, left);
                    return right;
                }
            }
            else if (key < root.val) root.left  = deleteNode(left, key);
            else                     root.right = deleteNode(right, key);
        }
        return root;
    }

    void addMin(TreeNode parent, TreeNode newChild) {
        while (parent.left != null)
            parent = parent.left;
        parent.left = newChild;
    }
}
