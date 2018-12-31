package ar.edu.utn.frc.mathutils.functions.elemental;

import ar.edu.utn.frc.mathutils.functions.util.FunctionsConstants;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;
import ar.edu.utn.frc.mathutils.functions.MathFunction;

public class IdentityFunction implements MathFunction {


    @Override
    public String expression() {
        return FunctionsConstants.VARIABLE;
    }

    @Override
    public MathFunction derivative() {
        return new ConstantFunction(FunctionsConstants.ONE);
    }

    @Override
    public Double apply(Double aDouble) {
        return aDouble;
    }
}
