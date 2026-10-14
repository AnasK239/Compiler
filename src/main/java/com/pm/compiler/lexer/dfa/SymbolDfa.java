package com.pm.compiler.lexer.dfa;

import com.pm.compiler.lexer.DfaMatch;

/** One small DFA can cover punctuation, operators, and assignment **/
public class SymbolDfa implements Dfa {
    @Override
    public DfaMatch scan(String source, int start) {
        // TODO: Add transitions for ; < = + - * / ( ) and :=
        // TODO: ':' leads to a nonaccepting state following '=' accepts ASSIGN
        // A lone ':' must not be accepted as a token.
        throw new UnsupportedOperationException("TODO: implement symbol DFA");
    }
}
