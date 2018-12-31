package ar.edu.utn.frc.mathutils.functions;

import java.util.function.Function;

public interface MathFunction extends Function<Double,Double> {
    String expression();
    MathFunction derivative();
}
