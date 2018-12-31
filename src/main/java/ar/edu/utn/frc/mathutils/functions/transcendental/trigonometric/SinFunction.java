package ar.edu.utn.frc.mathutils.functions.transcendental.trigonometric;

import ar.edu.utn.frc.mathutils.functions.FunctionsConstants;
import ar.edu.utn.frc.mathutils.functions.MathFunction;
import ar.edu.utn.frc.mathutils.functions.elemental.NegativeFunction;
import ar.edu.utn.frc.mathutils.functions.operations.ProductFunction;

public class SinFunction implements MathFunction {

    public static final String SIN_EXPRESSION = "SIN";
    private final MathFunction argument;

    public SinFunction(MathFunction argument) {
        this.argument = argument;
    }

    @Override
    public String expression() {
        return FunctionsConstants.formatFunction(SIN_EXPRESSION, argument);
    }

    @Override
    public MathFunction derivative() {
        return new ProductFunction(new NegativeFunction(new CosFunction(argument)),
                argument.derivative());
    }

    @Override
    public Double apply(Double aDouble) {
        return Math.sin(argument.apply(aDouble));
    }
}
