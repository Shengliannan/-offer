package com.sun.niuke;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 方法一：
 * 从头打印链表，放入ArrayList，然后翻转ArrayList
 * ArrayList没有reverse方法，需要自己实现
 * 方法二：
 * 使用递归
 * 方法三：
 * 使用栈
 */
public class FromTailToHeadPrintLinkedList {
    ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {


        ListNode<Integer> root = new ListNode(1);
        ListNode<Integer> n1 = new ListNode(2);
        ListNode<Integer> n2 = new ListNode(3);
        ListNode<Integer> n3 = new ListNode(4);
        ListNode<Integer> n4 = new ListNode(5);
        ListNode<Integer> n5 = new ListNode(6);
        root.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        /*FromTailToHeadPrintLinkedList formTailToHeadPrintLinkedList = new FromTailToHeadPrintLinkedList();
        formTailToHeadPrintLinkedList.printListFromTailToHead1(root);
        Iterator<Integer> iterator = formTailToHeadPrintLinkedList.arrayList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }*/

        FromTailToHeadPrintLinkedList formTailToHeadPrintLinkedList = new FromTailToHeadPrintLinkedList();
        ArrayList<Integer> arrayList1 = formTailToHeadPrintLinkedList.printListFromTailToHead(root);
        Iterator<Integer> iterator1 = arrayList1.iterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }


    }


    public ArrayList<Integer> printListFromTailToHead1(ListNode<Integer> listNode) {
        //实现递归，不满足条件，即没有到链表的末尾，就一直递归知道末尾，到末尾后就将元素加入list
        if(listNode!=null){
            printListFromTailToHead1(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 假设链表为：1->2->3->null
     *
     * ret init   (1)
     * ret.addAll(print(1.next)) ---
     * ret.add(1) ---             |
     *             |             ret init   (2)
     *             |             ret.addAll(print(2.next))   ---
     *             |             ret.add(2) ---               |
     *             |                         |               ret init   (3)
     *             |                         |               ret.addAll(print(3.next)) ---
     *             |                         |               ret.add(3)                 |
     *             |                         |                  |                     ret init   (4)
     *             |                         |               ret 3 (5)        <----    return ret
     *             |                      ret 3 2 (6) <----  return ret
     *        ret 3 2 1 (7)   <----       return ret
     *        return ret
     *  @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode<Integer> listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

}




