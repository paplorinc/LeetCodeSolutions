package leetcode.binaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * Example:
 * Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 *
 * Source: https://leetcode.com/problems/binary-watch/
 */
public class Solution {
  static final int LEDS = 10;
  public List<String> readBinaryWatch(int num) { return permute(new ArrayList<>(pow2(LEDS + 1)), 0, LEDS, num); }

  List<String> permute(List<String> results, int clock, int index, int remaining) {
    if (isValid(clock)) {
      if (remaining == 0) results.add(toString(clock));
      else if (index >= 0) {
        permute(results, clock,                index - 1, remaining);
        permute(results, setBit(clock, index), index - 1, remaining - 1);
      }
    }
    return results;
  }
  int pow2(int exponent)           { return 1 << exponent; }
  int setBit(int clock, int index) { return clock | pow2(index); }
  boolean isValid(int clock)       { return (hours(clock) < 12) && (minutes(clock) < 60); }
  int hours(int clock)             { return clock >>> 6; }
  int minutes(int clock)           { return clock & (-1 >>> -6); }
  String toString(int clock)       { return String.format("%d:%02d", hours(clock), minutes(clock)); }
}
