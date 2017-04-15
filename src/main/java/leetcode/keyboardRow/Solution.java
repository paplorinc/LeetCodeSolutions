package leetcode.keyboardRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 * Source: https://leetcode.com/problems/keyboard-row/
 */
public class Solution {
    public String[] findWords(String[] words) {
        List<String> results = new ArrayList<>(words.length);
        for (String word : words) {
            if (isSameLine(word))
                results.add(word);
        }
        return results.toArray(new String[0]);
    }
    static boolean isSameLine(String word) {
        int expectedLine = getLine(word.charAt(0));
        for (int i = 1; i < word.length(); i++)
            if (getLine(word.charAt(i)) != expectedLine)
                return false;
        return true;
    }
    static int getLine(char c) {
        switch(Character.toLowerCase(c)) {
            case 'q': case 'w': case 'e': case 'r': case 't': case 'y': case 'u': case 'i': case 'o': case 'p': return 0;
            case 'a': case 's': case 'd': case 'f': case 'g': case 'h': case 'j': case 'k': case 'l':           return 1;
            default:                                                                                            return 2;
        }
    }
}
