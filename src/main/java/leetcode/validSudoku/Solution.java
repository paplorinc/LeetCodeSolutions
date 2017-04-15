package leetcode.validSudoku;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 * Source: https://leetcode.com/problems/valid-sudoku/
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            Set<Character> encountered = new HashSet<>();
            for (int c = 0; c < board[r].length; c++)
                if ('.' != board[r][c] && !encountered.add(board[r][c]))
                    return false;
        }
                
        for (int c = 0; c < board[0].length; c++) {
            Set<Character> encountered = new HashSet<>();
            for (int r = 0; r < board.length; r++)
                if ('.' != board[r][c] && !encountered.add(board[r][c]))
                    return false;
        }
            
        
        int smallHeight = (int) Math.sqrt(board.length), smallWidth = (int) Math.sqrt(board[0].length);
        for (int r = 0; r < board.length; r += smallWidth)
            for (int c = 0; c < board[r].length; c += smallHeight) {
                Set<Character> encountered = new HashSet<>();
                for (int i = 0; i < smallHeight; i++)
                    for (int j = 0; j < smallWidth; j++)
                        if ('.' != board[r+i][c+j] && !encountered.add(board[r+i][c+j]))
                            return false; 
            }

        return true;
    }
}
