package ar.edu.utn.frc.mathutils.functions.transcendental.trigonometric;

import ar.edu.utn.frc.mathutils.functions.util.FunctionStringFormatter;
import ar.edu.utn.frc.mathutils.functions.MathFunction;
import ar.edu.utn.frc.mathutils.functions.operations.ProductFunction;

import java.util.Objects;

public class CosFunction implements MathFunction {

    public static final String COS_EXPRESSION = "COS";
    private final MathFunction argument;

    public CosFunction(MathFunction argument) {
        this.argument = argument;
    }

    @Override
    public String expression() {
        return FunctionStringFormatter.formatFunction(COS_EXPRESSION, argument);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CosFunction that = (CosFunction) o;
        return Objects.equals(argument, that.argument);
    }

    @Override
    public int hashCode() {

        return Objects.hash(argument);
    }
}
