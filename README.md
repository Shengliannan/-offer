# 剑指offer -> the code of self-training
## 一、二维数组中的查找 PS：编译环境(Java(javac 1.8))
### 题目描述：
#### 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
### Code:
```
/**
 * @author Sun Tiansheng
 * @version 1.0
 * @param  target int
 * @param  array  int[][]
 * @param  return boolean
 */
 
public class Solution {
    public boolean Find(int target, int [][] array) {
        boolean existFlag = false;  //flag:数组中是否存在target元素
        boolean seqFlag = true;     //flag:数组是否为有序的
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == target || array[i][j + 1] == target) {
                    existFlag = true;
                    if (array[i][j] > array[i][j + 1]) {
                        seqFlag = false;
                        break;
                    }
                }
            }
        }
        if (seqFlag) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] > array[i + 1][j]) {
                        seqFlag = false;
                        break;
                    }
                }
            }
        }
        if (existFlag && seqFlag) {
            return true;
        }
        return false;
    }
}
```
### Caution:
1. 当在数组中的元素进行两两比较的时候，应该多小心数组越界的问题，保证前后不越界，如此题中，if (array[i][j] > array[i][j + 1])中，因为j+1存在，所以for循环中的j>0,j+1<array[i].length,即，j>0,j<array[i].length-1。
2. 在程序中可以设置一些标志位，在不满足题目要求的条件后及时的退出，减少代码的运行时间。
