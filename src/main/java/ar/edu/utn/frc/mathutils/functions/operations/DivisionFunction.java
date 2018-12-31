package ar.edu.utn.frc.mathutils.functions.operations;

import ar.edu.utn.frc.mathutils.functions.elemental.NegativeFunction;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsConstants;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;
import ar.edu.utn.frc.mathutils.functions.MathFunction;

import java.util.Objects;

public class DivisionFunction implements MathFunction {

    private final MathFunction divisor;
    private final MathFunction dividend;

    public DivisionFunction(MathFunction divisor, MathFunction dividend) {
        this.divisor = divisor;
        this.dividend = dividend;
    }

    @Override
    public String expression() {
        return FunctionsUtils.formatDivision(divisor, dividend);
    }

    @Override
    public MathFunction derivative() {
        return new DivisionFunction(getDivisorOfDerivative(), getDividendOfDerivative());
    }

    @Override
    public Double apply(Double aDouble) {
        return divisor.apply(aDouble) / dividend.apply(aDouble);
    }

    private MathFunction getDivisorOfDerivative(){
        return new AddFunction(new ProductFunction(divisor.derivative(), dividend),
                new NegativeFunction(new ProductFunction(divisor, dividend.derivative())));
    }

    private MathFunction getDividendOfDerivative() {
        return new PowerFunction(dividend, FunctionsConstants.TWO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionFunction that = (DivisionFunction) o;
        return Objects.equals(divisor, that.divisor) &&
                Objects.equals(dividend, that.dividend);
    }

    @Override
    public int hashCode() {

        return Objects.hash(divisor, dividend);
    }
}
