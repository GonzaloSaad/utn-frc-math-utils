package ar.edu.utn.frc.mathutils.functions.elemental;

import ar.edu.utn.frc.mathutils.functions.util.FunctionsConstants;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;
import ar.edu.utn.frc.mathutils.functions.MathFunction;

public class ConstantFunction implements MathFunction{


    private final Double constant;

    public ConstantFunction(Double constant) {
        this.constant = constant;
    }

    @Override
    public String expression() {
        return Double.toString(constant);
    }

    @Override
    public MathFunction derivative() {
        return new ConstantFunction(FunctionsConstants.ZERO);
    }

    @Override
    public Double apply(Double aDouble) {
        return constant;
    }
}
