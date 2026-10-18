package com.pm.compiler.lexer;

import com.pm.compiler.token.TokenType;

import java.util.Map;

public class Dfa {
    private static final Map<String, TokenType> KEYWORDS = Map.of(
            "if", TokenType.IF,
            "then", TokenType.THEN,
            "end", TokenType.END,
            "repeat", TokenType.REPEAT,
            "until", TokenType.UNTIL,
            "read", TokenType.READ,
            "write", TokenType.WRITE
    );
    public DfaMatch scan(String source, int start) {

        int position = start;
        State state = State.START;
        TokenType tokenType = null;

        while (true) {
            boolean hasChar = position < source.length();
            char c = hasChar ? source.charAt(position) : '\0';

            switch (state) {
                case START ->{
                    if (!hasChar) {
                        return null;
                    }
                    else if (isDigit(c)) {
                        state = State.INNUM;
                        position++;
                    }
                    else if (isLetter(c)) {
                        state = State.INID;
                        position++;
                    }
                    else if (c == ':'){
                        state = State.INASSIGN;
                        position++;
                    }
                    else if (c == '{') {
                        state = State.INCOMMENT;
                        position++;
                    } else if (Character.isWhitespace(c)) {
                        position++;
                    }
                    else {
                        tokenType = getSymbol(c);
                        if (tokenType == null) {
                            throw new IllegalArgumentException("Unexpected character '" + c + "' at position " + position);
                        }
                        position++;
                        state = State.DONE;
                    }
                }

                case INNUM -> {
                    if (isDigit(c)) {
                        position++;
                    } else {
                        tokenType = TokenType.NUMBER;
                        state = State.DONE;
                    }
                }

                case INID -> {
                    if (isLetter(c)) {
                        position++;
                    } else {
                        String lexeme = source.substring(start, position).stripLeading();
                        tokenType = KEYWORDS.getOrDefault(lexeme, TokenType.IDENTIFIER);
                        state = State.DONE;
                    }
                }

                case INASSIGN -> {
                    if (c == '=') {
                        position++;
                        tokenType = TokenType.ASSIGN;
                        state = State.DONE;
                    } else {
                        throw new IllegalArgumentException("Expected '=' at position " + (position - 1)); // or we can add error token to follow the DFA exactly.
                    }
                }

                case INCOMMENT-> {
                    if (!hasChar) {
                        throw new IllegalArgumentException("Unterminated comment");
                    }
                    position++;

                    if (c == '}') {
                        state = State.DONE;
                        tokenType = TokenType.SKIP; // Comments are skipped in the lexer
                    }
                }
                case DONE -> {
                    return new DfaMatch(tokenType, position - start);
                }
            }

        }
    }
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private TokenType getSymbol(char c) {
        return switch (c) {
            case ';' -> TokenType.SEMICOLON;
            case '<' -> TokenType.LESSTHAN;
            case '=' -> TokenType.EQUAL;
            case '+' -> TokenType.PLUS;
            case '-' -> TokenType.MINUS;
            case '*' -> TokenType.MULT;
            case '/' -> TokenType.DIV;
            case '(' -> TokenType.OPENBRACKET;
            case ')' -> TokenType.CLOSEDBRACKET;
            default -> null;
        };
    }

}
