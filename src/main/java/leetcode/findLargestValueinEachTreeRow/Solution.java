package leetcode.findLargestValueinEachTreeRow;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * 
 * Output: [1, 3, 9]
 * 
 * 

 * Source: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        levelTraversal(root, level -> results.add(Collections.max(level)));
        return results;
    }
    private void levelTraversal(TreeNode root, Consumer<List<Integer>> consumer) {
        List<Integer> level = new LinkedList<Integer>();
        for (Queue<TreeNode> queue = new LinkedList<>(Arrays.asList(root, null)); root != null && !queue.isEmpty(); ) {
            TreeNode next = queue.remove();
            if (next == null) {
                consumer.accept(level);
                level.clear();
                if (!queue.isEmpty())
                    queue.add(null);
            } else {
                level.add(next.val);
                if (next.left != null) queue.add(next.left);
                if (next.right != null) queue.add(next.right);
            }
        }
    }
}
