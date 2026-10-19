package com.pm.compiler;

import com.pm.compiler.lexer.Lexer;
import com.pm.compiler.token.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Application entry point keep file input/output separate from scanning **/
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java Main <input-file>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of("output.txt");

        String source = Files.readString(inputPath);

        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.tokenize();

        List<String> lines = tokens.stream()
                .map(token -> token.lexeme() + ", " + token.type())
                .toList();

        Files.write(outputPath, lines);
    }

}
