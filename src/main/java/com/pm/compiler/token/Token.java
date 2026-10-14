package com.pm.compiler.token;

/** The lexeme is the exact source text e.g "0012", rather than a parsed value **/
public record Token(TokenType type, String lexeme) {}
