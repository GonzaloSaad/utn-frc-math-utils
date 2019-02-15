package ar.edu.utn.frc.mathutils.functions.util;

import ar.edu.utn.frc.mathutils.functions.MathFunction;

public abstract class FunctionStringFormatter {

    private static final String UNARY_FUNCTION_FORMAT = "%s(%s)";
    private static final String DIVISION_FUNCTION_FORMAT = "(%s/%s)";
    private static final String POWER_FUNCTION_FORMAT = "(%s)^(%s)";
    private static final String PRODUCT_FUNCTION_FORMAT = "(%s*%s)";

    public static String formatFunction(String functionPrint, MathFunction function) {
        return String.format(UNARY_FUNCTION_FORMAT, functionPrint, function.expression());
    }

    public static String formatDivision(MathFunction divisor, MathFunction dividend) {
        return String.format(DIVISION_FUNCTION_FORMAT, divisor.expression(), dividend.expression());
    }

    public static String formatPower(MathFunction base, MathFunction exponent) {
        return String.format(POWER_FUNCTION_FORMAT, base.expression(), exponent.expression());
    }

    public static String formatProduct(MathFunction firstProduct, MathFunction secondsProduct) {
        return String.format(PRODUCT_FUNCTION_FORMAT, firstProduct.expression(), secondsProduct.expression());
    }
}
