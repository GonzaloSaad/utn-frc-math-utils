package ar.edu.utn.frc.mathutils.functionparser.functionresolver;

import ar.edu.utn.frc.mathutils.functions.MathFunction;

public interface FunctionResolver {
    MathFunction resolveFunction(String function);
}
