package ar.edu.utn.frc.mathutils.functions.transcendental.trigonometric;

import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;
import ar.edu.utn.frc.mathutils.functions.MathFunction;
import ar.edu.utn.frc.mathutils.functions.operations.ProductFunction;

public class CosFunction implements MathFunction {

    public static final String COS_EXPRESSION = "COS";
    private final MathFunction argument;

    public CosFunction(MathFunction argument) {
        this.argument = argument;
    }

    @Override
    public String expression() {
        return FunctionsUtils.formatFunction(COS_EXPRESSION, argument);
    }

    @Override
    public MathFunction derivative() {
        return new ProductFunction(new SinFunction(argument),
                argument.derivative());
    }

    @Override
    public Double apply(Double aDouble) {
        return Math.cos(argument.apply(aDouble));
    }

}
