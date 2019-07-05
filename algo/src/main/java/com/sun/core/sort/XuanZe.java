package com.sun.core.sort;

public class XuanZe {
    /**
     *
     * 每次选择一个最大的放到最后面
     * n-1趟
     * 比较
     * 趟数 比较次数
     * 1      n-1
     * .       .
     * .       .
     * .       .
     * n-1     1
     */
    public static void main(String[] args) {
        int[] arr={2,3,5,1,7,9,6,0,4,8};
        xuanze(arr);
        printArr(arr);

    }

    public static void xuanze(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int max_index = 0;
            int j=0;
            for(j=1;j<n-i;j++){
                if (arr[j] > arr[max_index]){
                    max_index=j;
                }
            }
            int tmp = arr[max_index];
            arr[max_index] = arr[--j];  //内层for循环结束后，到达了数组的末尾+1，所以需要减去1
            arr[j] = tmp;
        }
    }

    public static void printArr(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
