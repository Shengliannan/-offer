package com.sun.core.sort;

public class KuaiPai {

    /**
     * 快速排序是一种交换排序
     * 借助递归 时间复杂度O(nlogn)
     * 选择一个数作为枢纽pivot,设置一个head，tail分别指向待排序序列的头和尾部，
     * 每一次做下标自增自减都要做边界控制
     */
    public static void main(String[] args) {
        int[] arr={2,3,5,1,7,9,6,0,4,8};
        int head = 0;
        int tail = arr.length-1;
        kuaipai(arr,head,tail);
        printArr(arr);
    }

    public static void kuaipai(int[] arr,int head,int tail){
        if(head<tail){
            int front = head;
            int rear = tail;
            int tmp = arr[head]; //取head为枢纽值。
            while(head<tail){
                while(arr[tail]>tmp){
                    if(tail<=front)
                        break;
                    tail--;
                }
                if(head>=tail){
                    break;
                }
                // 此时arr[tail] < tmp 交换
                arr[head++] = arr[tail];
                if(head>=tail){
                    break;
                }
                while(arr[head]<tmp){
                    if(head>=rear)  //不加，head会超出数组边界
                        break;
                    head++;
                }
                // 此时arr[head] > tmp 交换
                arr[tail--] = arr[head];
            }
            arr[head]=tmp;
            kuaipai(arr,front,head-1);
            kuaipai(arr,head+1,rear);
        }
    }

    public static void printArr(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+"\t");
        }
    }

}
