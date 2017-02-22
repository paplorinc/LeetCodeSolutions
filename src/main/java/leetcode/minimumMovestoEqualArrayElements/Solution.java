package leetcode.minimumMovestoEqualArrayElements;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * 
 * Example:
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * 

 * Source: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 */
public class Solution {
    public int minMoves(int... numbers) {
        int min = Arrays.stream(numbers).min().getAsInt();
        return Arrays.stream(numbers).map(v -> v - min).sum();
    }
}