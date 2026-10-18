package com.pm.compiler.token;

public enum TokenType {
    SEMICOLON,
    IF, THEN, END, REPEAT, UNTIL, READ, WRITE,
    IDENTIFIER,
    ASSIGN,
    LESSTHAN, EQUAL,
    PLUS, MINUS, MULT, DIV,
    OPENBRACKET, CLOSEDBRACKET,
    SKIP, // For comments skipping
    NUMBER,
    EOF // Internal marker do not write this to the output file
}
