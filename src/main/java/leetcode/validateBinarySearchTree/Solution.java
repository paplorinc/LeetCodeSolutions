package leetcode.validateBinarySearchTree;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * 
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * Example 1:
 * 
 * 2
 * / \
 * 1   3
 * 
 * Binary tree [2,1,3], return true.
 * 
 * 
 * Example 2:
 * 
 * 1
 * / \
 * 2   3
 * 
 * Binary tree [1,2,3], return false.
 * 

 * Source: https://leetcode.com/problems/validate-binary-search-tree/
 */
import java.util.concurrent.atomic.AtomicLong;
public class Solution {
    public boolean isValidBST(TreeNode root) { return isValidBST(root, new AtomicLong(Long.MIN_VALUE)); }
    private boolean isValidBST(TreeNode root, AtomicLong previous) {
       return (root == null) || isValidBST(root.left, previous) && previous.getAndSet(root.val) < root.val && isValidBST(root.right, previous);
    }
}
