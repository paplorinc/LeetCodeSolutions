package leetcode.validateBinarySearchTree;

import leetcode.TreeNode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Binary tree [2,1,3], return true.
 * <p>
 * Example 2:
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Binary tree [1,2,3], return false.
 * <p>
 * Source: https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Solution {
    public boolean isValidBST(TreeNode root) { return isValidBST(root, new AtomicLong(Long.MIN_VALUE)); }
    private boolean isValidBST(TreeNode root, AtomicLong previous) {
       return (root == null) || isValidBST(root.left, previous) && previous.getAndSet(root.val) < root.val && isValidBST(root.right, previous);
    }
}
