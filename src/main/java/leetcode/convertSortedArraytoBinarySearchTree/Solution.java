package leetcode.convertSortedArraytoBinarySearchTree;

import leetcode.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Source: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start >= end) return null;
        else {
            int mid = (end + start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid);
            root.right = sortedArrayToBST(nums, mid + 1, end);
            return root;
        }
    }
}

// 1 2 3
