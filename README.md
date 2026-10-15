# Architecture
<img width="1477" height="830" alt="image" src="https://github.com/user-attachments/assets/6134c2cb-a054-47cc-8ff3-2a7e3dd6fbf0" />


# Scanner skeleton

```text
com/pm/compiler/
  Main.java                 Read source and write the token listing
  token/
    Token.java              Token type and original source text (lexeme)
    TokenType.java          Assignment's token types plus internal EOF
  lexer/
    Lexer.java              Own the input position; expose getToken()
    DfaEngine.java          Choose the longest match across DFAs
    DfaMatch.java           Matched type and length
    dfa/
      Dfa.java              Common scan contract
      IdentifierDfa.java    Identifiers, then exact keyword classification
      NumberDfa.java        Integer literals
      SymbolDfa.java        Operators, parentheses, semicolon, and :=
```

## Suggested implementation order

1. Implement the three DFAs with the agreed lexical rules
2. Implement longest-match selection in DfaEngine
3. Implement Lexer.getToken(), including whitespace, EOF, and invalid input
4. Implement file input/output in Main

Useful later checks: `x:=4;`, `ifx`, adjacent operators, multiline whitespace,
an empty source, an invalid character, and an incomplete `:` assignment operator.
