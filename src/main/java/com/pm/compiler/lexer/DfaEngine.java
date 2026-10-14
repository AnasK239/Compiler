package com.pm.compiler.lexer;

import com.pm.compiler.lexer.dfa.Dfa;
import com.pm.compiler.lexer.dfa.IdentifierDfa;
import com.pm.compiler.lexer.dfa.NumberDfa;
import com.pm.compiler.lexer.dfa.SymbolDfa;

import java.util.List;

/** Runs all DFAs at the same starting position and selects the longest match **/
public class DfaEngine {
    private final List<Dfa> dfas = List.of(
            new IdentifierDfa(),
            new NumberDfa(),
            new SymbolDfa()
    );

    /** Returns null if no DFA accepts a nonempty prefix at start **/
    public DfaMatch scan(String source, int start) {
        // TODO: Run each DFA with the same source and start
        // TODO: Keep the longest non-null match on ties keep the first in dfas
        throw new UnsupportedOperationException("TODO: implement longest-match selection");
    }
}
