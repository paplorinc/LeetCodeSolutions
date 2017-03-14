package leetcode.minimumTimeDifference;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * 
 * Example 1:
 * 
 * Input: ["23:59","00:00"]
 * Output: 1
 * 
 * 
 * 
 * Note:
 * 
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 * 
 * 

 * Source: https://leetcode.com/problems/minimum-time-difference/
 */
import java.time.*;
import static java.util.stream.Collectors.*;
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<LocalTime> times = timePoints.stream().map(LocalTime::parse).sorted().collect(toList());

        int result = Integer.MAX_VALUE;
        LocalTime prev = times.get(times.size() - 1);
        for (LocalTime next : times) {
            result = Math.min(result, minutesDifference(prev, next));
            prev = next;
        }
        return result;
    }
    int minutesDifference(LocalTime t1, LocalTime t2) {
        Duration duration = Duration.between(t1, t2);
        return (int) (duration.isNegative() ? duration.plusDays(1) : duration).toMinutes();
    }
}
