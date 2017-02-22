package leetcode.pathSum;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 * Source: https://leetcode.com/problems/path-sum/
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
    public boolean hasPathSum(TreeNode root, int sum) {
        return (root != null)
               && ((root.left == root.right && root.val == sum)
                  || hasPathSum(root.left, sum - root.val)
                  || hasPathSum(root.right, sum - root.val));
    }
}