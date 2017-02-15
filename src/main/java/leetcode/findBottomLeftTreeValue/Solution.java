package leetcode.findBottomLeftTreeValue;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 2
 * / \
 * 1   3
 * 
 * Output:
 * 1
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * 
 * Output:
 * 7
 * 
 * 
 * 
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
 * 

 * Source: https://leetcode.com/problems/find-bottom-left-tree-value/
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
    public int findBottomLeftValue(TreeNode root) {
        int result = -1;
        for (Deque<TreeNode> queue = new ArrayDeque<>(Arrays.asList(root)); !queue.isEmpty(); ) {
            TreeNode last = queue.removeLast();
            if (last != null) {
                result = last.val;
                if (last.right != null) queue.addFirst(last.right);
                if (last.left != null) queue.addFirst(last.left);
            }
        }
        return result;
    }
}
