package com.sun.core.biTree;

public class BiTNode2<T> {
    public T val;
    public BiTNode2 lchild;
    public BiTNode2 rchild;
    public boolean lflag;
    public boolean rflag;
    public BiTNode2(T val){
        this.val = val;
        this.lchild=null;
        this.rchild=null;
        this.lflag=false;
        this.rflag=false;
    }
}
