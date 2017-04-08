package leetcode.mergeIntervals;

import leetcode.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * Source: https://leetcode.com/problems/merge-intervals/
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        else {
            intervals.sort(Comparator.comparing(i -> i.start)); 
            LinkedList<Interval> results = new LinkedList<>(Arrays.asList(intervals.get(0)));
            for (Interval interval : intervals) {
                if (interval.start > results.getLast().end) results.add(interval);
                else results.getLast().end = Math.max(results.getLast().end, interval.end);
            }
            return results;
        }
    }
}
