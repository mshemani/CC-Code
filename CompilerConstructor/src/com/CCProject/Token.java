package com.CCProject;

public class Token<T> {

    public String type;
    public T value;

    public Token(String type, T value) {
        this.type = type;
        this.value = value;
    }
}
