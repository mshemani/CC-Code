package com.CCProject;

public class Lexer {
     private char current_char ;
    private int pos;
   
    private final String text; 
    private final String 
        INTEGER = "INTEGER", PLUS = "PLUS", MINUS = "MINUS", MUL = "MUL", DIV = "DIV", EOF = "EOF" ,
        LP = "LP" , RP ="RP";

    public Lexer(String text) {
        this.text = text; 
        this.pos = 0; 
        this.current_char = this.text.charAt(this.pos); 
    }
    
    public void error() throws Exception {
        throw new Exception("Invalid token");
    }

    
    public void advance() {
        this.pos = this.pos + 1;
        if (this.pos >= this.text.length()) {
            this.current_char = '\0';
        } else {
            this.current_char = this.text.charAt(this.pos);
        }
    }
    
    public void skip_white_space() {
        while (this.current_char != '\0' && Character.isWhitespace(this.current_char)) {
            this.advance();
        }
    }
    
    public int Integer() {
        String result = "";
        while (this.current_char != '\0' && Character.isDigit(this.current_char)) {
            result += this.current_char;
            this.advance();
        }
        return Integer.parseInt(result);
    }
        public Token get_next_token() throws Exception {

            while (this.current_char != '\0') {
            
                if (Character.isWhitespace(this.current_char)) {
                this.skip_white_space(); 
                continue;
            } if (Character.isDigit(this.current_char)) { 
                return new Token(INTEGER, this.Integer()); 
            }  if (this.current_char == '+') {
                this.advance();
                return new Token(PLUS, '+');
            }  if (this.current_char == '-') {
                this.advance();
                return new Token(MINUS, '-');
            }  if (this.current_char == '*') {
                this.advance();
                return new Token(MUL, '*');
            }  if (this.current_char == '/') {
                this.advance();
                return new Token(DIV, '/'); 
            }  if (this.current_char == '(') {
                this.advance();
                return new Token(LP, '(');
            } if (this.current_char == ')') {
                this.advance();
                return new Token(RP, ')');
            }  
        }
        return new Token(EOF , '\0');
    }
}
