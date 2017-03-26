package leetcode.pathSumII;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 * /  \    / \
 * 7    2  5   1
 * 
 * 
 * 
 * return
 * 
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * 
 * 

 * Source: https://leetcode.com/problems/path-sum-ii/
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) { return pathSum(root, sum, new ArrayList<>(), new ArrayList<>()); }
    private List<List<Integer>> pathSum(TreeNode root, int sum, ArrayList<Integer> result, List<List<Integer>> results) {
        if (root != null) {
            result.add(root.val);
            if (root.left == root.right && sum == root.val) results.add((ArrayList) result.clone());
            else {
                pathSum(root.left,  sum - root.val, result, results);
                pathSum(root.right, sum - root.val, result, results);
            }
            result.remove(result.size() - 1);
        }
        return results;
    }
}
