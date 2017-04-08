package leetcode.diagonalTraverse;

import static java.lang.Math.min;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * <p>
 * Note:
 * <p>
 * The total number of elements of the given matrix will not exceed 10,000.
 * <p>
 * Source: https://leetcode.com/problems/diagonal-traverse/
 */
public class Solution {
    public int[] findDiagonalOrder(int[]... m) {
        int[] result = new int[(m.length == 0) ? 0 : m.length * m[0].length];
        for (int d = 0, i = 0; i < result.length; d++)
            for (int lo = d - min(d, m.length - 1), hi = min(d, m[0].length - 1); lo <= hi; )
                result[i++] = ((d & 1) == 0) ? m[d - lo][lo++] : m[d - hi][hi--];
        return result;
    }
}
