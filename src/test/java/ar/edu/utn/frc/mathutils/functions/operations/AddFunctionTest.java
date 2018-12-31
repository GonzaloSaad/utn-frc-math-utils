package ar.edu.utn.frc.mathutils.functions.operations;

import ar.edu.utn.frc.mathutils.functions.elemental.ConstantFunction;
import ar.edu.utn.frc.mathutils.functions.elemental.IdentityFunction;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AddFunctionTest {
    private static final Double CONSTANT = 5d;
    private static final String EXPECTED_RESULT_OF_EXPRESSION = "x+5.0";
    private static final Double ZERO = 0d;
    private static final Double ONE = 1d;
    private static final Double ARGUMENT = 3d;
    private static final Double EXPECTED_RESULT_OF_APPLY = 8d;

    private AddFunction addFunction;

    @Before
    public void setUp(){
        addFunction = new AddFunction(new IdentityFunction(), new ConstantFunction(CONSTANT));
    }

    @Test
    public void testConstantFunction(){
        assertEquals(new AddFunction(new ConstantFunction(ONE), new ConstantFunction(ZERO)), addFunction.derivative());
        assertEquals(EXPECTED_RESULT_OF_EXPRESSION, addFunction.expression());
        assertEquals(EXPECTED_RESULT_OF_APPLY, addFunction.apply(ARGUMENT));
    }
}
