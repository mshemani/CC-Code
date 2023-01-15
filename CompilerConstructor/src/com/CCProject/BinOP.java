package com.CCProject;

public class BinOP<T> extends AST {
    public T left;
    public T right;
    public Token op;
    public Token token;
    public BinOP(T left,Token op,T right){
      super();
      this.left =(T)  left;
      this.token =  this.op = op;
      this.right = (T) right;
    }
}
