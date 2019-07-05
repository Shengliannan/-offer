package com.sun.core.biTree;

/**
 * 后序遍历
 * 左 右 根
 */
public class PostTraverseTree {

    public static void main(String[] args) {
        BiTNode<String> root = new BiTNode("A");
        BiTNode<String> t1 = new BiTNode("B");
        BiTNode<String> t2 = new BiTNode("C");
        BiTNode<String> t3 = new BiTNode("D");
        root.lchild=t1;
        root.rchild=t2;
        t1.rchild=t3;
        PostTraverseTree postTraverseTree = new PostTraverseTree();
        postTraverseTree.postTraverseTre(root);
    }
    public void postTraverseTre(BiTNode root){
        if(root!=null){
            postTraverseTre(root.lchild);
            postTraverseTre(root.rchild);
            System.out.print(root.val+" ");
        }
    }

}
