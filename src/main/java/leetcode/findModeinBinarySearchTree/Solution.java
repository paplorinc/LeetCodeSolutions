package leetcode.findModeinBinarySearchTree;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * 
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * 1
 * \
 * 2
 * /
 * 2
 * 
 * 
 * 
 * return [2].
 * 
 * 
 * Note:
 * If a tree has more than one mode, you can return them in any order.
 * 
 * 
 * Follow up:
 * Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 * 

 * Source: https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
import java.util.concurrent.atomic.AtomicInteger;
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
