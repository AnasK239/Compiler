package com.pm.compiler.lexer.dfa;

import com.pm.compiler.lexer.DfaMatch;
import com.pm.compiler.token.TokenType;

import java.util.Map;

/** Recognizes identifiers and classifies exact keyword matches **/
public class IdentifierDfa implements Dfa {

    private static final Map<String, TokenType> KEYWORDS = Map.of(
            "if", TokenType.IF,
            "then", TokenType.THEN,
            "end", TokenType.END,
            "repeat", TokenType.REPEAT,
            "until", TokenType.UNTIL,
            "read", TokenType.READ,
            "write", TokenType.WRITE
    );

    @Override
    public DfaMatch scan(String source, int start) {
        int position = start;
        int state = 0;

        while (position < source.length()) {
            char c = source.charAt(position);

            switch (state){
                case 0:
                    if (Character.isLetter(c)) {
                        state = 1;
                    }else{
                        return null;
                    }
                    break;

                case 1:
                    if (!Character.isLetterOrDigit(c)){
                        String lexeme = source.substring(start, position);
                        TokenType type = KEYWORDS.getOrDefault(lexeme , TokenType.IDENTIFIER);
                        return new DfaMatch(type , position-start);
                    }
                    break;
            }
            position++;
        }

        if (state != 1){
            return null;
        }

        String lexeme = source.substring(start, position);
        TokenType type = KEYWORDS.getOrDefault(lexeme , TokenType.IDENTIFIER);
        return new DfaMatch(type , position-start);
    }
}
