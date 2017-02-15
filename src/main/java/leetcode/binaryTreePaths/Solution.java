package leetcode.binaryTreePaths;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * 
 * For example, given the following binary tree:
 * 
 * 
 * 
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * 
 * 
 * 
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/binary-tree-paths/
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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Arrays.asList();
        else return binaryTreePaths(root, "", new ArrayList<>());
    }
    List<String> binaryTreePaths(TreeNode root, String result, List<String> results) {
        result += root.val;
        if (root.left == root.right) results.add(result);
        else {
            if (root.left != null) binaryTreePaths(root.left, result + "->", results);
            if (root.right != null) binaryTreePaths(root.right, result + "->", results);
        }
        return results;
    }
}
