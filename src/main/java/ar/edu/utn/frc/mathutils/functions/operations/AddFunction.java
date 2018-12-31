package ar.edu.utn.frc.mathutils.functions.operations;

import ar.edu.utn.frc.mathutils.functions.MathFunction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddFunction implements MathFunction {

    private List<MathFunction> addends;

    public AddFunction(MathFunction... functions){
        addends = Arrays.asList(functions);
    }

    public AddFunction(List<MathFunction> functions){
        addends = functions;
    }

    @Override
    public Double apply(Double aDouble) {
        return addends.stream().mapToDouble(f -> f.apply(aDouble)).sum();
    }

    @Override
    public String expression() {
        return addends.stream().map(MathFunction::expression).collect(Collectors.joining("+"));
    }

    @Override
    public MathFunction derivative() {
        return new AddFunction(addends.stream().map(MathFunction::derivative).collect(Collectors.toList()));
    }
}
