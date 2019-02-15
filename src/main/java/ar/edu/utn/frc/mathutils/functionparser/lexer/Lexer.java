/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frc.mathutils.functionparser.lexer;

import ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme.Lexeme;
import ar.edu.utn.frc.mathutils.functionparser.lexer.stringexplorer.StringExplorer;
import ar.edu.utn.frc.mathutils.functionparser.lexer.token.Token;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * @author estre
 */
public class Lexer {

    private ArrayList<ArrayList<Lexeme>> lexemes;
    private final String string;

    public Lexer(String input) {
        string = input;
        lexemes = new ArrayList<>();
    }

    public ArrayList<Token> tokenize() {
        ArrayList<Token> tokens = new ArrayList<>();
        StringExplorer chars = new StringExplorer(string);
        String c;
        while (chars.hasNext()) {
            c = chars.getChar();
            Token t = null;
            for (int i = 0; i < lexemes.size(); i++) {
                t = scan(lexemes.get(i), i, chars);
                if (t != null) {
                    break;
                }
            }
            if (t == null) {
                t = scan(lexemes.get(0), 0, chars);
            }
            if (t == null) {
                throw new InputMismatchException("The symbol '" + c + "' isType invalid.");
            }
            tokens.add(t);
        }
        return tokens;
    }

    private Token scan(ArrayList<Lexeme> lexemes, int size, StringExplorer chars) {

        if (size == 0) {
            return scanMultiple(lexemes, chars);
        }
        String c = chars.getChars(size);

        Token t = null;
        if (c.equals(StringExplorer.NONE)) {
            return t;
        }
        for (Lexeme l : lexemes) {
            if (c.matches(l.getPat())) {
                t = new Token(l.getType(), c);
                break;
            }
        }

        if (t != null) {
            chars.move(size);
        }
        return t;
    }

    private Token scanMultiple(ArrayList<Lexeme> lexemes, StringExplorer chars) {
        for (Lexeme l : lexemes) {
            int step = 1;
            boolean found = false;
            String c = chars.getChars(step);

            while (!c.equals(StringExplorer.NONE)) {
                if (!c.matches(l.getPat())) {
                    break;
                }
                found = true;
                step++;
                c = chars.getChars(step);
            }
            if (found) {
                c = chars.getChars(step - 1);
                chars.move(step - 1);
                return new Token(l.getType(), c);
            }
        }
        return null;
    }

    // TODO: Take arrays out, and use list.
    public void addLexemes(Lexeme[] lexs) {

        for (Lexeme l : lexs) {
            int lexemeSize = l.size();
            int lexerSize = lexemes.size();

            if (lexerSize - 1 < lexemeSize) {
                int top = lexemeSize - lexerSize + 1;
                for (int i = 0; i < top; i++) {
                    lexemes.add(new ArrayList<>());
                }
            }
            lexemes.get(lexemeSize).add(l);
        }
    }
}
