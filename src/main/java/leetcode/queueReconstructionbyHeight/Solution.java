package leetcode.queueReconstructionbyHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * Note:
 * The number of people is less than 1,100.
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * Source: https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class Solution {
    public int[][] reconstructQueue(int[]... persons) {
        Arrays.sort(persons, Comparator.comparing(this::height).reversed().thenComparing(this::index));
        List<int[]> results = new ArrayList<>(persons.length);
        for (int[] person : persons) results.add(index(person), person);
        return results.toArray(persons);
    }
    int height(int[] person) { return person[0]; }
    int index(int[] person)  { return person[1]; }
}
