package leetcode.findModeinBinarySearchTree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * For example:
 * Given BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * return [2].
 * <p>
 * Note:
 * If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up:
 * Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 * <p>
 * Source: https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root != null) {
            AtomicInteger maxCount = new AtomicInteger();
            iterateDuplicates(root, (val, count) -> { if (count > maxCount.get()) maxCount.set(count); });
            iterateDuplicates(root, (val, count) -> { if (count == maxCount.get()) results.add(val); });
        }
        return results.stream().mapToInt(i -> i).toArray();
    }

    private void iterateDuplicates(TreeNode root, BiConsumer<Integer, Integer> consumer) {
        AtomicInteger lastVal = new AtomicInteger(), lastCount = new AtomicInteger(0);
        iterateInOrder(root, val -> {
            if (lastCount.get() == 0 || lastVal.get() == val) lastCount.incrementAndGet();
            else consumer.accept(lastVal.get(), lastCount.getAndSet(1));
            lastVal.set(val);
        });
        consumer.accept(lastVal.get(), lastCount.get());
    }

    private void iterateInOrder(TreeNode root, IntConsumer consumer) {
        if (root != null) {
            iterateInOrder(root.left, consumer);
            consumer.accept(root.val);
            iterateInOrder(root.right, consumer);
        }
    }
}
