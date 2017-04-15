package leetcode.implementStackusingQueues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and all test cases.
 *
 * Source: https://leetcode.com/problems/implement-stack-using-queues/
 */
public class MyStack {
    Queue<Integer> delegate = new ArrayDeque<>();
    public void push(int x) {
        delegate.add(x);
        for (int i = 1; i < delegate.size(); i++)
            delegate.add(delegate.remove());
    }

    public int pop() { return delegate.remove(); }
    public int top() { return delegate.peek(); }
    public boolean empty() { return delegate.isEmpty(); }
}
