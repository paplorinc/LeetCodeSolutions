package leetcode.setMatrixZeroes;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * click to show follow up.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * Source: https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        BitSet zeroRows = new BitSet(), zeroColumns = new BitSet();
        
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[r].length; c++)
                if (matrix[r][c] == 0) {
                    zeroRows.set(r);
                    zeroColumns.set(c);
                }

        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[r].length; c++)
                if (zeroRows.get(r) || zeroColumns.get(c))
                    matrix[r][c] = 0;
    }
}
