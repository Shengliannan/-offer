package com.sun.niuke;

/**
 *
 *
 * 递归 vs 动态规划
 * 递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 斐波那契数列
 * 0 1 2 3      4      5       ...   n
 * 0 1 1 2(1+1) 3(2+1) 5(3+2)  ...  f[n-1]+f[n-2]
 * 方法一：递归
 * 方法二：动态规划
 *
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(5));

    }

    /**
     * 递归实现斐波那契，要计算Fibonacci(n)需要计算Fibonacci(n-1)和Fibonacci(n-2)，
     * 只有Fibonacci(0)和Fibonacci(1)能计算出，然后递归返回该过程计算。
     *        /             0    n=0
     * f(n) = -             1    n=1
     *        \  f(n-1)+f(n-2)   n>1
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /**
     * 使用数组将每一步的结果保存，因为递归过程中有重合的子问题
     * 记录下来不用重复计算
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
       int[] fib = new int[n+1];
       fib[0]=0;
       fib[1]=1;
       fib[2]=1;
        for (int i = 3; i <= n; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
}
