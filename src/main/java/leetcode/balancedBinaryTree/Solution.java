package leetcode.balancedBinaryTree;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * 
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 

 * Source: https://leetcode.com/problems/balanced-binary-tree/
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
    public boolean isBalanced(TreeNode root) { return balancedHeight(root) != null; }
    Integer balancedHeight(TreeNode root) {
        if (root == null) return 0;
        else {
            Integer left = balancedHeight(root.left), right = balancedHeight(root.right);
            if (left == null || right == null || Math.abs(left - right) > 1) return null;
            else return 1 + Math.max(left, right);
        }
    }
}
