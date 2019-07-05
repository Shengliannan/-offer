package com.sun.train;

/**
 * 递归求数的最大值
 * 思想：将数组分为左右两部分，求左右两部分的最大值
 * 执行：会将数组拆分成不可拆分状态后，逐层返回最大值
 *                         7,2,4,1,8,9,3,10       (0-7)
 *                          /             \       (0+7)/2=3
 *         (0-3)      7,2,4,1          8,9,3,10   (4-7)
 *         (0+3)/2=1  /   \              /   \
 *         (0-1)   7,2   4,1 (2-3) (0-1)8,9  3,10 (2-3)
 *                / \    / \           / \   / \
 *               7  2   4  1          8  9  3  10
 */
public class FindMaxNumRecur {
    public static void main(String[] args) {
        int[] arr = {7,2,4,1,8,9,3,10};
        FindMaxNumRecur findMaxNumRecur = new FindMaxNumRecur();
        System.out.println(findMaxNumRecur.findMaxNumRecur(arr,0,arr.length-1));

    }

    public int findMaxNumRecur(int[] arr,int head,int tail){
        if(head>=tail){
            return arr[head];
        }
        int mid = tail-head/2;
        //mid-1 成为新的tail，mid成为新的head
        return Math.max(findMaxNumRecur(arr,head,mid-1),findMaxNumRecur(arr,mid,tail));
    }
}
