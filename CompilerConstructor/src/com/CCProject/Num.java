package com.CCProject;

public class Num<T> extends AST {

    public T Token;
    public int value;

    public Num(Token token) {
        super();
        this.Token = (T) token;
        this.value = (int) token.value;
    }
}
