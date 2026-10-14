package com.pm.compiler.lexer.dfa;

import com.pm.compiler.lexer.DfaMatch;

/** Recognizes the integer literals shown in the assignment **/
public class NumberDfa implements Dfa {
    @Override
    public DfaMatch scan(String source, int start) {
        // TODO: Define a start state and an accepting state for one or more digits
        // TODO: Consume digits using state transitions; return NUMBER and length
        // A minus sign is a separate MINUS token not part of the number
        throw new UnsupportedOperationException("TODO: implement number DFA");
    }
}
