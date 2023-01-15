package com.CCProject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser<T> {

    public Lexer lexer;
    public Token current_token;
    private final String INTEGER = "INTEGER", PLUS = "PLUS", MINUS = "MINUS", MUL = "MUL", DIV = "DIV", EOF = "EOF",
            LP = "LP", RP = "RP";

    public Parser(Lexer lex) {
        this.lexer = lex;
        try {
            this.current_token = this.lexer.get_next_token();
        } catch (Exception ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, "Class : Parser : Method contructor : Error = " + ex);
        }
    }

    public void error() throws Exception {
        throw new Exception("Invalid token");
    }

    public void verify_token(String token_type) throws Exception {
        if (this.current_token.type.equals(token_type)) {
            this.current_token = this.lexer.get_next_token();
        } else {
            this.error();
        }
    }

    public T factor() throws Exception {
        Token token = this.current_token;
        T node = null;
        switch (token.type) {
            case INTEGER:
                this.verify_token(INTEGER);
                return (T) new Num(token);
            case LP:
                this.verify_token(LP);
                node = this.expr();
                this.verify_token(RP);
                return node;
        }
        return null;

    }

    public T term() throws Exception {

        T node = this.factor();
       
        while (this.current_token != null && (this.current_token.type.equals(DIV) || this.current_token.type.equals(MUL))) {
        
            Token token = this.current_token;
            if (token.type.equals(MUL)) { 
                this.verify_token(MUL);

            } else if (token.type.equals(DIV)) {
                this.verify_token(DIV);

            }
            node = (T) new BinOP(node, token, this.factor());
        }
        return node; 

    }

    public T expr() throws Exception {

        T node = this.term();
        
        while (this.current_token != null && (this.current_token.type.equals(PLUS) || this.current_token.type.equals(MINUS))) {
            
            Token token = this.current_token;
            if (token.type.equals(PLUS)) { 
                this.verify_token(PLUS);

            } else if (token.type.equals(MINUS)) {
                this.verify_token(MINUS);

            }
            node = (T) new BinOP(node, token, this.factor());
        }
        return node; 

    }

    public T parse() throws Exception {
        return this.expr();
    }
}
