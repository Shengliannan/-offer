package com.sun.core.sort;

public class ChaRu {
    /**
     * 从小到大排序
     * 把序列分为有序序列和无序序列，第一次假设序列的第一个值有序，无序序列中的每个元素curr与有序序列中的比较，从后向前比较，只要不小于于curr的元素，交换。
     * 难点还是在于：边界控制
     * @param args
     */
    public static void main(String[] args) {
        int[] arr={2,3,5,1,7,9,6,0,4,8};
        charu(arr);
    }

    public static void charu(int[] arr){
        int n = arr.length;
        for(int i=1;i<n-1;i++){   //i=0,j=1;i=n-2,j=n-1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i=j;
                }
            }
        }
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
