package leetcode.fizzBuzz;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * 
 * Example:
 * 
 * n = 15,
 * 
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * 
 * 

 * Source: https://leetcode.com/problems/fizz-buzz/
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>(n);
        for (int i = 1; i <= n; i++)
                 if (divides(i,  3*5)) results.add("FizzBuzz");
            else if (divides(i,  3))   results.add("Fizz");
            else if (divides(i,  5))   results.add("Buzz");
            else                       results.add(String.valueOf(i));
        return results;
    }
    boolean divides(int i, int j) { return (j != 0) && (i % j == 0); }
}
