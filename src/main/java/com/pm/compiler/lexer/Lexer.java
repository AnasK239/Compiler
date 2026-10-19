package com.pm.compiler.lexer;

import com.pm.compiler.token.Token;
import com.pm.compiler.token.TokenType;

import java.util.ArrayList;
import java.util.List;

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
        while(position < source.length() &&
                Character.isWhitespace(source.charAt(position))){
            position++;
        }
        if (position >= source.length()) {
            return new Token(TokenType.EOF, "");
        }

        DfaMatch result = Dfa.scan(source, position);
        String lexeme = source.substring(position, position +  result.length());
        position += result.length();
        return new Token(result.type() , lexeme);
    }

    public List<Token> tokenize() {
        List<Token> results = new ArrayList<>();

        while (position < source.length()) {
            Token token = getToken();
            if(token.type() == TokenType.SKIP) continue;
            if(token.type() == TokenType.EOF) break;
            results.add(token);
        }

        return results;
    }
}
