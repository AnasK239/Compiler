package com.pm.compiler.lexer;

public enum State {
    START,
    INNUM,
    INID,
    INASSIGN,
    INCOMMENT,
    DONE
}
