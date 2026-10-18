package com.pm.compiler.lexer;

import com.pm.compiler.token.Token;

/** Owns the source and the current position **/
public class Lexer {
    private final String source;
    private int position;

    public Lexer(String source) {
        this.source = source;
        this.position = 0;
    }

    /** Returns the next token, or EOF once the source is exhausted **/
    public Token getToken() {
        // TODO: Skip whitespace and return EOF if at the end
        // TODO: Ask engine.scan(source, position) for the longest match
        // TODO: If no DFA matches, report an invalid character with its position
        // TODO: Extract the lexeme, advance position by match.length(), return Token
        // The lexer alone advances position, DFAs must not change it
        throw new UnsupportedOperationException("TODO: implement getToken");
    }
}
