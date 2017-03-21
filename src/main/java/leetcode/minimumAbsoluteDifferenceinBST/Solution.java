package leetcode.minimumAbsoluteDifferenceinBST;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * 
 * 
 * Example:
 * 
 * Input:
 * 
 * 1
 * \
 * 3
 * /
 * 2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note:
 * There are at least two nodes in this BST.
 * 

 * Source: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
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
    Integer previous;
    public int getMinimumDifference(TreeNode root) {
        if (root != null) {
            int diff = getMinimumDifference(root.left);
            
            if (previous != null)
                diff = Math.min(diff, Math.abs(previous - root.val));
                
            previous = root.val;
            return Math.min(diff, getMinimumDifference(root.right));
        }
        return Integer.MAX_VALUE;
    }
}
