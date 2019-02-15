package ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme;

public enum LexemeType {
    OP("Operation"),
    LP("Left parentheses"),
    RP("Right parentheses"),
    CST("Constant"),
    FUN("Function"),
    NUM("Number"),
    CFF("Coefficient"),
    VAR("Variable");


    private String text;

    LexemeType(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
