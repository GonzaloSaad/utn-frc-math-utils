package ar.edu.utn.frc.mathutils.functionparser.exceptions;

public class ParenthesesNotBalancedException extends RuntimeException {
    public ParenthesesNotBalancedException(String message) {
        super(message);
    }
}
