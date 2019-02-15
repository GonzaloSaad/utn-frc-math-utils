package ar.edu.utn.frc.mathutils.functions.elemental;

import ar.edu.utn.frc.mathutils.functions.util.FunctionStringFormatter;
import ar.edu.utn.frc.mathutils.functions.MathFunction;

import java.util.Objects;

public class NegativeFunction implements MathFunction {

    public static final String NEGATIVE_EXPRESSION = "-";
    private final MathFunction argument;

    public NegativeFunction(MathFunction argument) {
        this.argument = argument;
    }


    @Override
    public String expression() {
        return FunctionStringFormatter.formatFunction(NEGATIVE_EXPRESSION, argument);
    }

    @Override
    public MathFunction derivative() {
        return new NegativeFunction(argument.derivative());
    }

    @Override
    public Double apply(Double aDouble) {
        return -1d * argument.apply(aDouble);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NegativeFunction that = (NegativeFunction) o;
        return Objects.equals(argument, that.argument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(argument);
    }
}
