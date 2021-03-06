package leetcode.addTwoNumbersII;

import leetcode.ListNode;

import java.math.BigDecimal;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * <p>
 * Source: https://leetcode.com/problems/add-two-numbers-ii/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { return asList(asBigDecimal(l1).add(asBigDecimal(l2))); }

    private BigDecimal asBigDecimal(ListNode node) {
        BigDecimal result = BigDecimal.ZERO;
        for (; node != null; node = node.next)
            result = result.movePointRight(1).add(BigDecimal.valueOf(node.val));
        return result;
    }

    private ListNode asList(BigDecimal num) {
        ListNode result = new ListNode(0), head = result;
        for (char d : num.toString().toCharArray())
            head = (head.next = new ListNode(d - '0'));
        return result.next;
    }
}
