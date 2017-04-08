package leetcode.rotateList;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.

 * Source: https://leetcode.com/problems/rotate-list/
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head != null) {
            ListNode kth = head;
            for (int size = size(head), i = (k % size) + 1; i < size; i++)
                kth = kth.next;
            
            ListNode end = kth;
            while (end.next != null)
                end = end.next;
            
            end.next = head;
            head = kth.next;
            kth.next = null;
        }        
        return head;
    }

    private static int size(ListNode head) {
        int result = 0;
        for (; head != null; head = head.next)
            result++;
        return result;
    }
}
