package ar.edu.utn.frc.mathutils.functions.elemental;

import ar.edu.utn.frc.mathutils.functions.util.FunctionsConstants;
import ar.edu.utn.frc.mathutils.functions.MathFunction;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstantFunction that = (ConstantFunction) o;
        return Objects.equals(constant, that.constant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constant);
    }
}
