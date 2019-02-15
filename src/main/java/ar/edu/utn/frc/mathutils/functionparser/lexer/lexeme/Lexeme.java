/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme;

/**
 * @author estre
 */
public class Lexeme {

    private LexemeType type;
    private String pat;
    public static final int SIZE_ONE = 1;
    public static final int BIG_SIZE = 0;

    public Lexeme(LexemeType type, String pat) {
        this.type = type;
        this.pat = pat;
    }

    public String getPat() {
        return pat;
    }

    public LexemeType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Lexeme(" + this.type + ",'" + this.pat.replace("\\", "") + "')";
    }

    public int size() {
        if (pat.matches("\\[.-.\\](?![\\*\\+\\[])")) {
            return SIZE_ONE;
        }

        int tam = 0;

        for (int i = 0; i < pat.length(); i++) {
            char c = pat.charAt(i);
            if (c == '\\') {
                continue;
            }
            tam++;

        }

        if (tam > 0 && (pat.contains("*") || pat.contains("+"))) {
            return BIG_SIZE;
        }
        return tam;
    }
}
