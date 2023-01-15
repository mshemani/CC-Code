package com.CCProject;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter numbers and operator between them:");
        String inp = myObj.nextLine();

        Lexer lexer = new Lexer(inp);
        Parser parser = new Parser(lexer);
        Interpreter intepret = new Interpreter(parser);
        int res = intepret.interpret();

       
        System.out.println("Result : " + res);
    }

}
