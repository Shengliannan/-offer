package com.sun.core.sort;

public class Duipai {
    /**
     *堆排有两个步骤：1.建堆 2.筛选
     * 时间复杂度O(nlogn)=建堆O(logn)*筛选O(n)
     * 思想：建堆，交换第一个和最后一个，再建堆，序列减1
     */
    public static void main(String[] args) {
        int[] arr={2,3,5,1,7,9,6,0,4,8};
        duipai(arr);
        printArr(arr);
    }

    /*
   从第一个非叶子节点开始调整，也就是n/2开始调整，从下往上调整，从右往左调整
    */
    public static void duipai(int[] arr){
        int n = arr.length-1;
        for (int i = n; i >= 0 ; i--) {
           for(int j = i/2;j>=0;j--){
               heap(arr,j,i);
           }
           swap(arr,0,i);
        }



    }


    //调堆过程
    public static void heap(int[] arr,int loc,int n){ //loc每次需要记录需要进行堆调的节点
        if(2*loc+1<=n){ //非叶子节点
            int maxj = 2*loc+1;
            if(2*loc+2<=n){ //存在右子树
                if(arr[maxj]<arr[2*loc+2]){ //左子树和右子树中选择大的
                    maxj = 2*loc+2;
                }
            }
            if(arr[loc]>arr[maxj]){ //根节点小于左子树和右子树中的最大值,最大值为根节点，不需要交换
                return ;
            }
            swap(arr,maxj,loc);
            heap(arr,maxj,n);
        }
    }


    public static void swap(int[] arr,int m,int n){
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void printArr(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+"\t");
        }
    }

}
