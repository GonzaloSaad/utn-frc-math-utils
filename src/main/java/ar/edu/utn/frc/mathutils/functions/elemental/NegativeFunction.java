package ar.edu.utn.frc.mathutils.functions.elemental;

import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;
import ar.edu.utn.frc.mathutils.functions.MathFunction;

public class NegativeFunction implements MathFunction {

    public static final String NEGATIVE_EXPRESSION = "-";
    private final MathFunction argument;

    public NegativeFunction(MathFunction argument) {
        this.argument = argument;
    }


    @Override
    public String expression() {
        return FunctionsUtils.formatFunction(NEGATIVE_EXPRESSION, argument);
    }

    @Override
    public MathFunction derivative() {
        return new NegativeFunction(argument.derivative());
    }

    @Override
    public Double apply(Double aDouble) {
        return -1d * argument.apply(aDouble);
    }
}
