package com.sun.niuke;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 测试ArrayList的函数
 * add
 * addAll
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(2);
        // addAll 将一个list加入到两一个list中
        a1.addAll(a2);
        Iterator<Integer> iterator = a1.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }

}
