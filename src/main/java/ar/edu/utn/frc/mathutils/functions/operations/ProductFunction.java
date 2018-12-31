package ar.edu.utn.frc.mathutils.functions.operations;

import ar.edu.utn.frc.mathutils.functions.MathFunction;
import ar.edu.utn.frc.mathutils.functions.util.FunctionsUtils;

public class ProductFunction implements MathFunction {

    private MathFunction firstProduct;
    private MathFunction secondsProduct;

    public ProductFunction(MathFunction firstProduct, MathFunction secondsProduct){
        this.firstProduct = firstProduct;
        this.secondsProduct = secondsProduct;
    }

    @Override
    public Double apply(Double aDouble) {
        return firstProduct.apply(aDouble) * secondsProduct.apply(aDouble);
    }

    @Override
    public String expression() {
        return FunctionsUtils.formatProduct(firstProduct, secondsProduct);
    }

    @Override
    public MathFunction derivative() {
        return new AddFunction(new ProductFunction(firstProduct.derivative(), secondsProduct),
                new ProductFunction(firstProduct, secondsProduct.derivative()));
    }
}
