package com.pm.compiler.lexer.dfa;

import com.pm.compiler.lexer.DfaMatch;

/** Recognizes identifiers and classifies exact keyword matches **/
public class IdentifierDfa implements Dfa {
    @Override
    public DfaMatch scan(String source, int start) {
        // TODO: Define states and transitions for the identifier rules
        // TODO: Scan the entire accepted word before checking for a keyword
        // Keywords: if, then, end, repeat, until, read, write
        // Example: "if" is IF, but "ifx" is IDENTIFIER
        throw new UnsupportedOperationException("TODO: implement identifier DFA");
    }
}
