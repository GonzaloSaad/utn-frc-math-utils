/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frc.mathutils.functionparser.lexer;

import ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme.Lexeme;
import ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme.LexemeType;
import ar.edu.utn.frc.mathutils.functionparser.lexer.token.Token;

import java.util.ArrayList;

/**
 * @author estre
 */
public class FunctionLexer {

    private Lexer lexer;

    public FunctionLexer(String input, String[] variables) {
        lexer = new Lexer(input);
        defineLexemes();
        variablesLexemes(variables);
    }

    public FunctionLexer(String input) {
        this(input, new String[]{"x"});
    }

    private void defineLexemes() {
        simpleLexemes();
        dualLexemes();
        triLexemes();
        multiLexemes();

    }

    private void simpleLexemes() {
        Lexeme[] lexemes = new Lexeme[]{
                new Lexeme(LexemeType.OP, "\\+"),
                new Lexeme(LexemeType.OP, "-"),
                new Lexeme(LexemeType.OP, "\\*"),
                new Lexeme(LexemeType.OP, "/"),
                new Lexeme(LexemeType.OP, "\\^"),
                new Lexeme(LexemeType.LP, "\\("),
                new Lexeme(LexemeType.RP, "\\)"),
                new Lexeme(LexemeType.CST, "e")
        };
        lexer.addLexemes(lexemes);
    }

    private void dualLexemes() {
        Lexeme[] lexemes = new Lexeme[]{
                new Lexeme(LexemeType.CST, "pi"),};
        lexer.addLexemes(lexemes);
    }

    private void triLexemes() {
        Lexeme[] lexemes = new Lexeme[]{
                new Lexeme(LexemeType.FUN, "sin"),
                new Lexeme(LexemeType.FUN, "cos"),
                new Lexeme(LexemeType.FUN, "log"),};
        lexer.addLexemes(lexemes);
    }

    private void multiLexemes() {
        Lexeme[] lexemes = new Lexeme[]{
                new Lexeme(LexemeType.NUM, "[0-9]+(\\.[0-9]*)?(?!.)"),
                new Lexeme(LexemeType.NUM, "\\.[0-9]*(?!.)"),
                new Lexeme(LexemeType.CFF, "[A-Z][0-9]*"),};
        lexer.addLexemes(lexemes);
    }

    private void variablesLexemes(String[] vars) {
        int qt = vars.length;
        Lexeme[] l = new Lexeme[qt];
        for (int i = 0; i < qt; i++) {
            l[i] = new Lexeme(LexemeType.VAR, vars[i]);
        }
        lexer.addLexemes(l);
    }

    public ArrayList<Token> tokenize() {
        return lexer.tokenize();
    }
}
