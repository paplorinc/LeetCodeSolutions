package leetcode.implementQueueusingStacks;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * 
 * push(x) -- Push element x to the back of queue.
 * 
 * 
 * pop() -- Removes the element from in front of queue.
 * 
 * 
 * peek() -- Get the front element.
 * 
 * 
 * empty() -- Return whether the queue is empty.
 * 
 * 
 * Notes:
 * 
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * 
 * 

 * Source: https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {
    Stack<Integer> front = new Stack<>(), back = new Stack<>();
    public void push(int x) { back.push(x); }
    public int pop()        { return normalizedFront().pop(); }
    public int peek()       { return normalizedFront().peek(); }
    public boolean empty()  { return back.isEmpty() && front.isEmpty(); }
    Stack<Integer> normalizedFront() {
        if (front.isEmpty()) {
            front = back;
            Collections.reverse(front);
            back = new Stack<>();
        }
        return front;
    }
}
