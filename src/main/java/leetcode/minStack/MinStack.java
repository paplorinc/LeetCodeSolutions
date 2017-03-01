package leetcode.minStack;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 

 * Source: https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    Deque<Deque<Integer>> delegate = new ArrayDeque<>();
    public void push(int x) {
        if (delegate.isEmpty() || x < getMin())
            delegate.addLast(new ArrayDeque<>());
        delegate.getLast().addLast(x);
    }

    public void pop() {
        delegate.getLast().removeLast();
        if (delegate.getLast().isEmpty())
            delegate.removeLast();
    }

    public int top() { return delegate.getLast().getLast(); }
    public int getMin() { return delegate.getLast().getFirst(); }
}
