package com.sun.core.biTree;


/**
 *            A
 *           / \
 *          B  C
 *          \
 *          D
 */
public class PreTraverseTree {
    public static void main(String[] args) {
        BiTNode<String> root = new BiTNode("A");
        BiTNode<String> t1 = new BiTNode("B");
        BiTNode<String> t2 = new BiTNode("C");
        BiTNode<String> t3 = new BiTNode("D");
        root.lchild=t1;
        root.rchild=t2;
        t1.rchild=t3;
        PreTraverseTree preTraverseTree = new PreTraverseTree();
        preTraverseTree.preTraverseTree(root);
    }


    /**
     * 递归前序遍历：根 左 右
     * 如果不为空就访问，然后遍历左子树，遍历右子树
     * @param root
     */
    public void preTraverseTree(BiTNode root){
        if(root!=null){
            System.out.print(root.val + " ");
            preTraverseTree(root.lchild);
            preTraverseTree(root.rchild);
        }
    }


}
