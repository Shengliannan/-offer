package com.sun.niuke;


/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 */
public class RepeatNumInArray {
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int[] duplication=new int[1];
        RepeatNumInArray repeatNumInArray = new RepeatNumInArray();
        repeatNumInArray.duplicate(nums,nums.length,duplication);
    }


    /**
     * 最简单的实现，暴力
     * 时间复杂度为O(n)
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        for (int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++)
            {
                if(numbers[i]==numbers[j]){
                    duplication[0]=numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 由于长度为n的数组，数字的范围在0-n-1之间
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        //当前位置上的元素放置在合适的位置上，而不是把别的符合的元素放置在当前位置上
        for (int i = 0; i < length; i++) {
            // 只要当前位置不等于元素值，就交换
            while (nums[i] != i) {
                // 只要当前位置不等于元素值并且nums[i] == nums[nums[i]]就说明重复
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
