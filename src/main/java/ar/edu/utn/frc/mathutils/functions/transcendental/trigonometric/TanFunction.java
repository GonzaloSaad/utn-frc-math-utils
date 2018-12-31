package ar.edu.utn.frc.mathutils.functions.transcendental.trigonometric;

import ar.edu.utn.frc.mathutils.functions.elemental.ConstantFunction;
import ar.edu.utn.frc.mathutils.functions.operations.DivisionFunction;
import ar.edu.utn.frc.mathutils.functions.operations.PowerFunction;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsConstants;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;
import ar.edu.utn.frc.mathutils.functions.MathFunction;
import ar.edu.utn.frc.mathutils.functions.elemental.NegativeFunction;
import ar.edu.utn.frc.mathutils.functions.operations.ProductFunction;

public class TanFunction implements MathFunction {

    public static final String TAN_EXPRESSION = "TAN";
    private final MathFunction argument;

    public TanFunction(MathFunction argument) {
        this.argument = argument;
    }

    @Override
    public String expression() {
        return FunctionsUtils.formatFunction(TAN_EXPRESSION, argument);
    }

    @Override
    public MathFunction derivative() {
        return new DivisionFunction(argument.derivative(),
                new PowerFunction(new CosFunction(argument), FunctionsConstants.TWO));
    }

    @Override
    public Double apply(Double aDouble) {
        return Math.tan(argument.apply(aDouble));
    }
}
