# 剑指offer -> the code of self-training
## 一、二维数组中的查找 PS：编译环境(Java(javac 1.8))
题目描述：
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
Code:
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



编程心得：

1. StringBuffer没有toCharArray()方法，可以str.toString().toCharArray()操作

2. ArrayList没有reverse()函数

3. ArrayList 取值get()函数，修改值set()函数，get和indexOf的区别：

   get是获取i位置上的元素：通过下标找元素。

   indexOf是返回指定元素的下标：通过元素找下标。

4. ArrayList<Integer>转int数组，手动循环；

   > 参考：http://www.myasker.com/archives/160.html

```
Arrays.asList(a) 中a的元素必须是引用类型。
```





### 牛客网-剑指offer

#### 2.替换空格
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
```java
/*StringBuffer没有toCharArray()方法，可以str.toString().toCharArray()操作*/

public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        char[] strChar = str.toString().toCharArray();
        for(int i=0;i<strChar.length;i++){
            if(strChar[i]==' ')
                sb.append("%20");
            else
                sb.append(strChar[i]);
        }
        return sb.toString();          
    }
}
```

#### 3.从尾到头打印链表
题目描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
```java
/*
1.int[] a,ArrayList<Integer>的转换问题
2.Arrays工具包的使用
3.ArrayList增删改查，以及遍历问题
4.ArrayList没有reverse()函数。
5.while(index<tail)  rather than while(index!=tail) 数组下标越界问题。
*/

public class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        ListNode p = listNode;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            a[i] = list.get(i);

        int index = 0;
        int tail = a.length - 1;
        while (index < tail) {
            a[index] = a[index] ^ a[tail];
            a[tail] = a[index] ^ a[tail];
            a[index] = a[index] ^ a[tail];
            index++;
            tail--;
        }

        ArrayList<Integer> reverseList = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            reverseList.add(a[i]);
        }
        return reverseList;
    }
}
```

#### 4. 重建二叉树
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

```java
/*
1.不用专门声明一个变量来保存二叉树的头指针，在二叉树的建立过程中，每次递归都建立了二叉树节点之间的相互关系，在递归返回后，这种关系依然保留。
2.思路：初始先从前序数组中找根，通过根将中序数组分为左右子数组，即左右子数。然后再通过中序子数组在前序数组中确定根，依次递归即可。递归出口：子数组的start<=end
3.关键代码：
if(start<=end){
            int root = findRoot(pre,in,start,end);
            tn = new TreeNode(pre[root]);
            int index = findIndex(in,pre[root]);
            tn.left=createTree(pre,in,start,index-1);
            tn.right=createTree(pre,in,index+1,end);
        }
*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return createTree(pre,in,0,in.length-1);
    }
    
    public static TreeNode createTree(int[] pre,int[] in,int start,int end){
        TreeNode tn=null;
        if(start<=end){
            int root = findRoot(pre,in,start,end);
            tn = new TreeNode(pre[root]);
            int index = findIndex(in,pre[root]);
            tn.left=createTree(pre,in,start,index-1);
            tn.right=createTree(pre,in,index+1,end);
        }
        return tn;
    }

    public static int findIndex(int[] arr,int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }

    public static int findRoot(int[] pre,int[] in,int start,int end){
        int rootIndex = Integer.MAX_VALUE;
        int tmp = -1;
        while(start<=end){
            if((tmp=findIndex(pre,in[start]))<rootIndex){
                rootIndex = tmp;
            }
            start++;
        }
        return rootIndex;
    }
}
```

#### 5. 用两个栈实现队列
题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

```java
/**
 * 思想：用栈模拟队列
 * 栈：先入后出
 * 队列：先入先出
 * 入队列时，入A栈，出队列时，出A栈，入B栈，在入A栈。
 */
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        int element = 0;
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        if(!stack2.isEmpty()){
            element = stack2.pop();
        }

        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return element;
    }
}
```

#### 6. 旋转数组的最小数字(//todo)

#### 7. 菲波那切数列

题目描述

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。

n<=39

```
/**
 * 方法一：空间换时间，初始化一个n+1长度的数组，记录菲波那切数列的每一项。
 * 优点：不会爆栈，速度快
 * 缺点：需要初始化n+1长度的数组
 */
public class Solution {
    public int Fibonacci(int n) {
       if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n>1) {
            int[] arr = new int[n+1];
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n];
        }
        return -1;
    }
}

/**
 * 方法二：递归
 * 优点：代码简易
 * 缺点：可能会爆栈
 */
public class Solution {
    public int Fibonacci(int n) {
       if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return Fibonacci(n-2) + Fibonacci(n-1);
    }
}
```

#### 8.跳台阶

题目描述：

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

```java
/*
递归难点：递归调用函数之间如何传递信息（参数，返回值）
调动者通过参数将信息传递给被调用者
被调用者通过返回值将信息传递给调用者

注：如果题目给定的函数声明中变量或者返回值不满足要求，可自己定义函数后被题目中函数调用
*/
//注意：1.最底return是程序执行完了返回。2.判断中的return是满足条件了返回。

public class FrogJumpStep {
    static int count = 0;
    static int sum = 0;
    public static void main(String[] args) {
        FrogJumpStep fjs = new FrogJumpStep();
        System.out.println(fjs.JumpFloor(10));
    }

    public int JumpFloor(int target) {
        return jump(target,0);
    }

    public int jump(int target,int sum){
        if(sum>=target){
            if(sum==target)
                count++;
            return count;
        }else{
            for (int i = 1; i <= 2 ; i++) {
                sum+= i;
                jump(target,sum);
                sum-=i;
            }
        }

        return count;
    }
}
```

```java
/*
对于本题,前提只有 一次 1阶或者2阶的跳法。

a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);

b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)

c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 

d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2

e.可以发现最终得出的是一个斐波那契数列：
       | 1, (n=1)
f(n) = | 2, (n=2)
       | f(n-1)+f(n-2) ,(n>2,n为整数)
*/

public class Solution {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target ==2) {
            return 2;
        } else {
            return  JumpFloor(target-1)+JumpFloor(target-2);
        }
    }
}
```

