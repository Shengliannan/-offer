package com.sun.niuke;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class TwoDArrayFind {
    public static void main(String[] args) {
        int[][] array = new int[4][];
        // 输出为5，为二维数组中的行个数的值
        //二维数组的赋值
        int[] c1 = {1,2,3,4};
        int[] c2 = {5,8,9,10};
        int[] c3 = {6,11,13,14};
        int[] c4 = {7,12,15,16};
        array[0]=c1;
        array[1]=c2;
        array[2]=c3;
        array[3]=c4;
        TwoDArrayFind twoDArrayFind = new TwoDArrayFind();
        boolean flag = twoDArrayFind.Find(20,array);
        System.out.println(flag);
    }

    /**
     * 暴力解法，遍历二维数组
     * @param target
     * @param array
     * @return
     */
    public boolean Find1(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(target==array[i][j]){
                    return true;
                }
            }

        }
        return false;
    }


    /**
     *  1   2    3    4
     *  5   8    9    10
     *  6   11   13   14
     *  7   12   15   16
     *
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
     * 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
     * 也可从左下开始，上边的都小于它，右边的都大于它
     * 例如，target=13
     * 1.4>13 10
     * 2.10>13 14
     * 3.13<14 13
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        int rows = array.length, cols = array[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        //r为下边界，c为左边界
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c])
                return true;
            else if (target > array[r][c])
                //target大于当前元素，向下走
                r++;
            else
                //target小于当前元素，向左走
                c--;
        }
        return false;
    }
}
