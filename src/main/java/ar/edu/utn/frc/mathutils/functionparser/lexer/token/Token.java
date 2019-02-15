/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frc.mathutils.functionparser.lexer.token;

import ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme.LexemeType;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author estre
 */
public class Token {

    private final LexemeType type;
    private final String value;

    public Token(LexemeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public LexemeType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public boolean isNumber(){
        return isType(LexemeType.NUM) || isType(LexemeType.CST);
    }

    public boolean isOperator(){
        return isType(LexemeType.FUN) || isType(LexemeType.OP);
    }

    public boolean isType(LexemeType lexemeType){
        return type == lexemeType;
    }

    public boolean isOneOf(List<String> values){
        return values.contains(this.value);
    }

    @Override
    public String toString() {
        return "Token(" + type.toString() + ",'" + value + "')";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(type, token.type) &&
                Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
