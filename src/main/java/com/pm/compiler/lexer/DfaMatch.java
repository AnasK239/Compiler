package com.pm.compiler.lexer;

import com.pm.compiler.token.TokenType;

/** A successful DFA match length must be greater than zero **/
public record DfaMatch(TokenType type, int length) {}
