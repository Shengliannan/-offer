package com.sun.niuke;

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思想：
 * 队列 FIFO
 * 栈 FILO
 * 队列操作：入队，出队
 *
 * 入队
 *      入栈1
 * 出队
 *      栈2不为空，栈2出栈
 *      栈2为空，栈1依次出栈入栈2，然后栈2出栈
 */
public class TwoStackMakeQueue {

    public static void main(String[] args) {

    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //入队，入栈1
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 出队
     * 栈2不为空，栈2出栈
     * 栈2为空，栈1依次出栈入栈2，然后栈2出栈
     * @return
     */
    public int pop() {
        if(stack2.isEmpty()){
            //栈2为空
            while(!stack1.isEmpty()){
                //栈1依次出栈，入栈2
                stack2.push(stack1.pop());
            }
            //栈2出栈
            return stack2.pop();
        }
        //栈2不为空，栈2出栈
        return stack2.pop();

    }
}
