package ar.edu.utn.frc.mathutils.functions.operations;

import ar.edu.utn.frc.mathutils.functions.MathFunction;
import ar.edu.utn.frc.mathutils.functions.elemental.ConstantFunction;
import ar.edu.utn.frc.mathutils.functions.util.FunctionStringFormatter;

import java.util.Objects;

public class PowerFunction implements MathFunction {

    private final MathFunction base;
    private final Double exponent;

    public PowerFunction(MathFunction base, Double exponent) {
        this.base = base;
        this.exponent = exponent;
    }


    @Override
    public String expression() {
        return FunctionStringFormatter.formatPower(base, new ConstantFunction(exponent));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerFunction that = (PowerFunction) o;
        return Objects.equals(base, that.base) &&
                Objects.equals(exponent, that.exponent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, exponent);
    }
}
