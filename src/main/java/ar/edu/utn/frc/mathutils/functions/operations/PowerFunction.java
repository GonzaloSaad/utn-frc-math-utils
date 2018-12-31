package ar.edu.utn.frc.mathutils.functions.operations;

import ar.edu.utn.frc.mathutils.functions.MathFunction;
import ar.edu.utn.frc.mathutils.functions.elemental.ConstantFunction;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;

public class PowerFunction implements MathFunction {

    private final MathFunction base;
    private final Double exponent;

    public PowerFunction(MathFunction base, Double exponent) {
        this.base = base;
        this.exponent = exponent;
    }


    @Override
    public String expression() {
        return FunctionsUtils.formatPower(base, new ConstantFunction(exponent));
    }

    @Override
    public MathFunction derivative() {
        return new ProductFunction(new ConstantFunction(exponent),
                new ProductFunction(new PowerFunction(base, exponent - 1) , base.derivative()));
    }

    @Override
    public Double apply(Double aDouble) {
        return Math.pow(base.apply(aDouble), exponent);
    }
}
