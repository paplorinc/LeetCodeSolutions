package leetcode.minesweeper;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 * 
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 * 
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 * 
 * 
 * 
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * 
 * Click : [3,0]
 * 
 * Output:
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * 
 * Click : [1,2]
 * 
 * Output:
 * 
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 * 
 * 

 * Source: https://leetcode.com/problems/minesweeper/
 */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0], x = click[1];
        if (isMine(board, y, x)) board[y][x] = 'X';
        else reveal(board, getInfo(board), y, x);
        return board;
    } 
    private int[][] getInfo(char[][] board) {
        int[][] info = new int[board.length][board[0].length];
        for (int y = 0; y < info.length; y++)
            for (int x = 0; x < info[y].length; x++)
                if (isMine(board, y, x))
                    mark(info, board, y, x);
        return info;
    } 
    private void reveal(char[][] board, int[][] info, int y, int x) {
        if (isEmpty(board, y, x)) {
            if (info[y][x] == 0) {
                board[y][x] = 'B';
                for (int dy : new int[]{-1, 0, 1})
                    for (int dx : new int[]{-1, 0, 1})
                        reveal(board, info, y + dy, x + dx);
            } else board[y][x] = (char) ('0' + info[y][x]);
        }
    } 
    private boolean isMine(char[][] board, int y, int x)  { return isValid(board, y, x) && board[y][x] == 'M'; } 
    private boolean isEmpty(char[][] board, int y, int x) { return isValid(board, y, x) && board[y][x] == 'E'; } 
    private void mark(int[][] info, char[][] board, int y, int x) {
        for (int dy : new int[]{-1, 0, 1})
            for (int dx : new int[]{-1, 0, 1}) {
                int newY = y + dy, newX = x + dx;
                if (isValid(board, newY, newX))
                    info[newY][newX]++;
            }
    } 
    private boolean isValid(char[][] board, int y, int x) { return y >= 0 && y < board.length && x >= 0 && x < board[y].length; }
}
