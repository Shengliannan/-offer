package com.sun.core.sort;

public class Maopao {

    /**
     * 冒泡排序
     * 最好时间：O(n) 在序列已经有序的情况下
     * 最坏时间: 0(n^2)
     * 参考：https://blog.csdn.net/u010853261/article/details/54891710
     */
    public static void main(String[] args) {
        int[] arr={2,3,5,1,7,9,6,0,4,8};
        maopao1(arr);
        maopao2(arr);
        maopao3(arr);
    }


    /**
     * 两两交换，需要比较，移动元素两个步骤
     * 1. 每一趟，把最大的放到数组的最后，一共需要n-1趟。
     * 关键词：交换
     * 2. 需要两两比较，第一次需要比较n-1次，第二次需要比较n-2次，第三次比较n-3次，...，第n-1趟比较1次。
     * 走完每一趟后，下一趟要交换的次数就会减1，可通过外层控制
     * 交换为基本操作
     * 第i趟需要交换的次数为n-i
     *  趟数  交换次数
     *  1       n-1
     *  .        .
     *  .        .
     *  .        .
     *  n-1      1
     * 注意事项：边界检查
     */
    public  static void maopao1(int[] arr){
        for(int i=0;i<=arr.length-2;i++){
            for(int j=1;j<=arr.length-1-i;j++){
                if (arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        printArr(arr);
    }

    /**
     * 改进版：
     * 设置一个标志位，加入在一趟中没有交换操作
     * 则认为数组已经有序
     */
    public static void maopao2(int[] arr){
        for(int i=0;i<=arr.length-2;i++){
            boolean flag=false;
            for(int j=1;j<=arr.length-1-i;j++){
                if (arr[j-1]>arr[j]){
                    flag = true;
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
            if(flag){
                break;
            }
        }
        printArr(arr);

    }

    public static void maopao3(int[] arr){

    }

    public static void printArr(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+"\t");
        }
    }

}
