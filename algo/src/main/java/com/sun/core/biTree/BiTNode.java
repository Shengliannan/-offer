package com.sun.core.biTree;

public class BiTNode<T> {
    public T val;
    public BiTNode lchild;
    public BiTNode rchild;
    public BiTNode(T val){
        this.val = val;
        this.lchild=null;
        this.rchild=null;
    }
}

