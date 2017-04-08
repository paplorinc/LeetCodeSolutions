package leetcode.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 
 * Source: https://leetcode.com/problems/pascals-triangle/
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> result = new ArrayList<>(i + 1);
            result.add(1);
            if (i > 0) {
                List<Integer> prev = results.get(i - 1);
                for (int j = 1; j < i; j++)
                    result.add(prev.get(j - 1) + prev.get(j));
                result.add(1);
            }
            results.add(result);
        }
        return results;
    }
}
