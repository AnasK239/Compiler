package com.pm.compiler.lexer.dfa;

import com.pm.compiler.lexer.DfaMatch;
import com.pm.compiler.token.TokenType;

public class IdentifierDfaTest {

    public static void main(String[] args) {
        IdentifierDfa dfa = new IdentifierDfa();

        check(dfa, "abc123", 0, new DfaMatch(TokenType.IDENTIFIER, 6));

        check(dfa, "if", 0, new DfaMatch(TokenType.IF, 2));

        check(dfa, "ifx", 0, new DfaMatch(TokenType.IDENTIFIER, 3));

        check(dfa, "read;", 0, new DfaMatch(TokenType.READ, 4));

        check(dfa, "abc:=4", 0, new DfaMatch(TokenType.IDENTIFIER, 3));

        check(dfa, "42 abc;", 3, new DfaMatch(TokenType.IDENTIFIER, 3));

        check(dfa, "123abc", 0, null);
        check(dfa, ";", 0, null);
        check(dfa, "", 0, null);
        check(dfa, "abc", 3, null);

        System.out.println("All identifier DFA tests passed!");
    }

    private static void check(IdentifierDfa dfa, String source, int start, DfaMatch expected) {
        DfaMatch actual = dfa.scan(source, start);

        if (!java.util.Objects.equals(expected, actual)) {
            throw new AssertionError(
                    "Input: \"" + source + "\", start: " + start
                            + "\nExpected: " + expected
                            + "\nActual:   " + actual
            );
        }
    }
}