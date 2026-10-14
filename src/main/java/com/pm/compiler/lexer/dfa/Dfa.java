package com.pm.compiler.lexer.dfa;

import com.pm.compiler.lexer.DfaMatch;

public interface Dfa {
    /**
     * Finds the longest accepted prefix beginning exactly at start
     * Return null if nothing is accepted otherwise return a positive length
     * Use explicit DFA states/transitions and remember the last accepting position
     * Keep scan state local so the same DFA can be called repeatedly
     * Never skip ahead to find a match or change the lexer's position
     */
    DfaMatch scan(String source, int start);
}
