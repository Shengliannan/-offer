package com.sun.niuke;

public class TwoDArray {
    public static void main(String[] args) {
        //二维数组初始化必须指定行标，列表可指定也可不指定
        int[][] array = new int[4][];
        // 输出为5，为二维数组中的行个数的值
        System.out.println(array.length);
        //二维数组的赋值
        int[] c1 = {1,2,3,4};
        int[] c2 = {5,8,9,10};
        int[] c3 = {6,11,13,14};
        int[] c4 = {7,12,15,16};
        array[0]=c1;
        array[1]=c2;
        array[2]=c3;
        array[3]=c4;

        //二维数组的遍历
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"   ");
            }
            System.out.println();
        }

    }
}
