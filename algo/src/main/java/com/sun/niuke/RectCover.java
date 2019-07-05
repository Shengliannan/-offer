package com.sun.niuke;

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思想；
 *  关注的不是每一种情况如何放，而是关注有几种放置的方法
 */
public class RectCover {
    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        System.out.println(rectCover.RectCover(3));
    }
    public int RectCover(int target) {
        /*if(target<0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }*/
        if (target <= 2) {
            return target;
        }
        return RectCover(target-1)+RectCover(target-2);
    }
}
