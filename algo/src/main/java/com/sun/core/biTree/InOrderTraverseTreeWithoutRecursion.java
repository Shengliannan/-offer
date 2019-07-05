package com.sun.core.biTree;


import java.util.Stack;

/**
 * 和中序遍历一样
 * 区别
 *  先序是访问后入栈
 *  中序是出栈访问
 */
public class InOrderTraverseTreeWithoutRecursion {
    public static void main(String[] args) {
        BiTNode<String> root = new BiTNode("A");
        BiTNode<String> t1 = new BiTNode("B");
        BiTNode<String> t2 = new BiTNode("C");
        BiTNode<String> t3 = new BiTNode("D");
        root.lchild=t1;
        root.rchild=t2;
        t1.rchild=t3;
        InOrderTraverseTreeWithoutRecursion inOrderTraverseTreeWithoutRecursion = new InOrderTraverseTreeWithoutRecursion();
        inOrderTraverseTreeWithoutRecursion.inOrderTraverseTreeWithoutRecursion(root);
    }

    /**
     * 前序遍历非递归，借助栈来实现
     * 入栈前访问
     * 节点非空，栈不为空就执行
     * 左子树不为空，一直入栈
     * 栈不为空，出栈，向右走
     *
     * @param root
     */
    public void inOrderTraverseTreeWithoutRecursion(BiTNode root){
        Stack<BiTNode> stack = new Stack();
        BiTNode p = root;
        /**
         * 若树不为空，就访问入栈
         */


        while(p!=null||!stack.isEmpty()){
            //左子树不为空，一直入栈
            while(p!=null) {

                stack.push(p);
                p = p.lchild;
            }
            //p为null
            if(!stack.isEmpty()){
                /*
                // 出栈
                // BiTNode p = stack.pop(); 会一直打印，因为如果有右子树，会向右走，没有右子树，不应该为
                BiTNode t = stack.pop();
                //出栈节点不为空，p向右走，为空，p不动
                if(t.rchild!=null){
                    //向右走
                    p=t.rchild;
                }
                */

                //将右子树是否为空由左子树循环判断
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.rchild;

            }
        }
    }
}
