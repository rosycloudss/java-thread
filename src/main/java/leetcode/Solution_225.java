package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-30
 */
public class Solution_225 {

}

class MyStack {

    LinkedList<Integer> queue = new LinkedList<>();
    int top = -1;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        top++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int result = queue.get(top);
        queue.remove(top);
        top --;
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.get(top);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}