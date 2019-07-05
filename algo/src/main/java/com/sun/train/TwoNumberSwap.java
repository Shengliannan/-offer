package com.sun.train;

/**
 * 两个数字进行交换
 */
public class TwoNumberSwap {

    public static void main(String[] args) {
        TwoNumberSwap.xor(3,5);
        TwoNumberSwap.addSubtract(3,5);

    }

    /**
     * 通过异或交换a,b的值
     * @param a
     * @param b
     */
    public static void xor (int a,int b){
        System.out.println("xor:");
        System.out.println("before:"+"a:"+a+","+"b:"+b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("after:"+"a:"+a+","+"b:"+b);
    }

    /**
     * 通过加减交换a,b的值
     * @param a
     * @param b
     */
    public static void addSubtract(int a,int b){
        System.out.println("addSubtract:");
        System.out.println("before:"+"a:"+a+","+"b:"+b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("after:"+"a:"+a+","+"b:"+b);
    }
}
