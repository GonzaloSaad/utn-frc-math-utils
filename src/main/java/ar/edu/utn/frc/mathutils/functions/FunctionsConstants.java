package ar.edu.utn.frc.mathutils.functions;

public abstract class FunctionsConstants {

    private static final String UNARY_FUNCTION_FORMAT = "%s(%s)";
    private static final String DIVISION_FUNCTION_FORMAT = "(%s/%s)";


    public static final String VARIABLE = "x";
    public static final Double ZERO = 0d;
    public static final Double ONE = 1d;



    public static String formatFunction(String functionPrint, MathFunction function){
        return String.format(UNARY_FUNCTION_FORMAT, functionPrint, function);
    }

    public static String formatDivision(MathFunction divisor, MathFunction dividend){
        return String.format(DIVISION_FUNCTION_FORMAT, divisor, dividend);
    }
}
