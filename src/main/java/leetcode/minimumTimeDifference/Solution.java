package leetcode.minimumTimeDifference;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * <p>
 * Example 1:
 * <p>
 * Input: ["23:59","00:00"]
 * Output: 1
 * <p>
 * Note:
 * <p>
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 * <p>
 * Source: https://leetcode.com/problems/minimum-time-difference/
 */
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
