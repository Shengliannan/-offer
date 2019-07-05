package com.sun.core.biTree;

/**
 * 中序遍历 递归实现
 * 左 根 右
 */
public class InOrderTraverseTree {
    public static void main(String[] args) {
        BiTNode<String> root = new BiTNode("A");
        BiTNode<String> t1 = new BiTNode("B");
        BiTNode<String> t2 = new BiTNode("C");
        BiTNode<String> t3 = new BiTNode("D");
        root.lchild=t1;
        root.rchild=t2;
        t1.rchild=t3;
        InOrderTraverseTree inOrderTraverseTree = new InOrderTraverseTree();
        inOrderTraverseTree.inOrderTraverseTree(root);

    }
    public void inOrderTraverseTree(BiTNode root){
        if(root!=null){
            inOrderTraverseTree(root.lchild);
            System.out.print(root.val+" ");
            inOrderTraverseTree(root.rchild);
        }
    }
}
