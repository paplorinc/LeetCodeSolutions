package leetcode.binaryTreeLevelOrderTraversalII;

import leetcode.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * Source: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Arrays.asList();
        else {
            int remaining = 1;
            LinkedList<List<Integer>> results = new LinkedList<>();
            for (Deque<TreeNode> queue = new ArrayDeque<>(Arrays.asList(root)); !queue.isEmpty(); )
                results.addFirst(consumeLevel(queue, new ArrayList<>()));
            return results;
        }
    }
    List<Integer> consumeLevel(Deque<TreeNode> queue, List<Integer> result) {
        Deque<TreeNode> newQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            result.add(node.val);

            if(node.left  != null) newQueue.addLast(node.left);
            if(node.right != null) newQueue.addLast(node.right);
        }
        queue.addAll(newQueue);
        return result;
    }
}
