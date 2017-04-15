package leetcode.binarySearchTreeIterator;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Credits:Special thanks to @ts for adding this problem and creating all test cases.
 *
 * Source: https://leetcode.com/problems/binary-search-tree-iterator/
 */
class BSTIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode n) { addMin(n); }

    public boolean hasNext() { return !stack.isEmpty(); }
    public int next() {
        TreeNode n = stack.pop();
        addMin(n.right);
        return n.val;
    }
    private void addMin(TreeNode n) {
        for (; n != null; n = n.left)
            stack.push(n);
    }
}
