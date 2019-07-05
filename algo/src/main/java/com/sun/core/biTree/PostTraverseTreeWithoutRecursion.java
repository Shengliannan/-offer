package com.sun.core.biTree;

import java.util.Stack;

/**
 * 后序遍历非递归
 * 两次返回
 * 第一次返回不出栈，也不访问
 * 主要问题：
 * 什么时候该出栈，第一次返回时出栈（走到最左），第二次返回时出栈（右为空或者右已访问）
 * 思想：
 * 1. 两个栈实现
 *    两个while循环
 *    p入栈1，p出栈1，p入栈2
 *    p左不为空，入栈1，p右不为空，入栈1
 *    栈2不为空，依次弹出
 *
 * 2. 构造的数据结构实现,lflag,rflag （加标志位）
 *
 * 3. 无法通过根右左的入栈顺序实现出栈顺序是左右根的顺序
 * 若右不为空，一直右走，右为空后不能出栈，无法走到左子树
 */
public class PostTraverseTreeWithoutRecursion {

    public static void main(String[] args) {
        /*
        //设置标志位
        BiTNode2<String> root = new BiTNode2("A");
        BiTNode2<String> t1 = new BiTNode2("B");
        BiTNode2<String> t2 = new BiTNode2("C");
        BiTNode2<String> t3 = new BiTNode2("D");
        root.lchild=t1;
        root.rchild=t2;
        t1.rchild=t3;
        PostTraverseTreeWithoutRecursion postTraverseTreeWithoutRecursion = new PostTraverseTreeWithoutRecursion();
        postTraverseTreeWithoutRecursion.postTraverseTreeWithoutRecursion(root);*/

        //两个栈
        BiTNode<String> root = new BiTNode("A");
        BiTNode<String> t1 = new BiTNode("B");
        BiTNode<String> t2 = new BiTNode("C");
        BiTNode<String> t3 = new BiTNode("D");
        root.lchild=t1;
        root.rchild=t2;
        t1.rchild=t3;
        PostTraverseTreeWithoutRecursion postTraverseTreeWithoutRecursion = new PostTraverseTreeWithoutRecursion();
        postTraverseTreeWithoutRecursion.postTraverseTreeWithoutRecursion1(root);
    }

    /**
     * 采用构造的一种数据结构,lflag,rflag
     * 初始flag为flase,第一次返回lflag=true,第二次返回rflag=true;
     * @param root
     */
    public void postTraverseTreeWithoutRecursion(BiTNode2 root){
        BiTNode2 p = root;
        Stack<BiTNode2> stack = new Stack<>();
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.lchild;
            }
            if(!stack.isEmpty()){
                p = stack.peek();
                /**
                 * 若
                 * 1. 右子树为空（右子树不存在）
                 * 2. 右子树不为空，左子树lfag=true（右子树存在，也返回）
                 * 出栈访问
                 */
                if(p.rchild==null||p.lflag){

                    //出栈，并设置工作指针为null，否则还会对已操作的结点重复操作
                    p = stack.pop();
                    System.out.print(p.val+" ");
                    p = null;
                 }else{
                    //第一次返回，设置lflag=true,然后向右走
                     p.lflag=true;
                     p=p.rchild;
                 }
            }
        }
    }


    /**
     *
     * 采用两个栈实现，只有在栈1弹出时，入栈2，弹出节点左右不为空都入栈1
     * @param root
     */
    public void postTraverseTreeWithoutRecursion1(BiTNode root){
        Stack<BiTNode> stack1 = new Stack<>();
        Stack<BiTNode> stack2 = new Stack<>();
        BiTNode p = root;
        stack1.push(p);
        //栈1不为空
        while(!stack1.isEmpty()){
            //栈1弹出，入栈2
            p = stack1.pop();
            stack2.push(p);
            //弹出节点左不为空
            if(p.lchild!=null){
                //入栈1
                stack1.push(p.lchild);
            }
            //弹出节点右不为空
            if(p.rchild!=null){
                //入栈1
                stack1.push(p.rchild);
            }
        }

        while(!stack2.isEmpty()){
            p = stack2.pop();
            System.out.print(p.val+" ");
        }
    }
}
