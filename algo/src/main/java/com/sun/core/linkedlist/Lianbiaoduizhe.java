package com.sun.core.linkedlist;


import com.sun.niuke.ListNode;

import java.util.Stack;

/**
 * 1. 求中点
 * 2. 后半段逆置
 * 3. 合并链表
 *
 * 思想：借助栈实现，后半段的每个结点的地址用栈记录，就不用逆置链表了
 */
public class Lianbiaoduizhe {
    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode(1);
        ListNode<Integer> l1 = new ListNode(2);
        ListNode<Integer> l2 = new ListNode(3);
        ListNode<Integer> l3 = new ListNode(4);
        ListNode<Integer> l4 = new ListNode(5);
        list.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Lianbiaoduizhe lianbiaoduizhe = new Lianbiaoduizhe();
        lianbiaoduizhe.lianbiaoduizhe(list);
        ListNode p = list;
        while(p!=null){
            System.out.print(p.val+"->");
            p = p.next;
        }
    }

    public ListNode lianbiaoduizhe(ListNode list){
        Stack<ListNode> stack = new Stack();
        ListNode workP = list;
        //将链表中的结点依次入栈
        while(workP!=null){
            stack.push(workP);
            workP = workP.next;
        }
        workP = list;
        //workQ用来记录剩余链表的头结点
        ListNode workQ=null;
        for (int i = 0; i < stack.size()/2; i++) {
            workQ = workP.next;
            //将栈中元素弹出，拼接到新链表中
            workP.next = stack.pop();
            workP.next.next = workQ;
            //移动工作指针，继续拼接后序内容
            workP=workQ;
        }
        //新的链表拼接完成后，将新链表的链表尾结点的next置为null，否则会打印出原位置的内容
        workQ.next = null;
        return list;
    }
}
