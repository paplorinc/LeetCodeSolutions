package leetcode.integertoRoman;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * 
 * Input is guaranteed to be within the range from 1 to 3999.

 * Source: https://leetcode.com/problems/integer-to-roman/
 */
public class Solution {
    public String intToRoman(int num) {
        if      (num >= 1000) return "M"  + intToRoman(num - 1000);
        else if (num >= 900)  return "CM" + intToRoman(num - 900);
        else if (num >= 500)  return "D"  + intToRoman(num - 500);
        else if (num >= 400)  return "CD" + intToRoman(num - 400);
        else if (num >= 100)  return "C"  + intToRoman(num - 100);
        else if (num >= 90)   return "XC" + intToRoman(num - 90);
        else if (num >= 50)   return "L"  + intToRoman(num - 50);
        else if (num >= 40)   return "XL" + intToRoman(num - 40);
        else if (num >= 10)   return "X"  + intToRoman(num - 10);
        else if (num >= 9)    return "IX" + intToRoman(num - 9);
        else if (num >= 5)    return "V"  + intToRoman(num - 5);
        else if (num >= 4)    return "IV" + intToRoman(num - 4);
        else if (num >= 1)    return "I"  + intToRoman(num - 1);
        else                  return "";
    }
}
