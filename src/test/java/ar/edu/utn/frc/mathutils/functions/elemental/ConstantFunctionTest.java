package ar.edu.utn.frc.mathutils.functions.elemental;

import ar.edu.utn.frc.mathutils.functionparser.functionresolver.ShuntingYardAlgorithm;
import ar.edu.utn.frc.mathutils.functionparser.lexer.FunctionLexer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConstantFunctionTest {

    private static final Double CONSTANT = 5d;
    private static final String CONSTANT_STRING = "5.0";
    private static final Double ZERO = 0d;

    private ConstantFunction constantFunction;

    @Before
    public void setUp(){
        constantFunction = new ConstantFunction(CONSTANT);
    }

    @Test
    public void testConstantFunction(){
        assertEquals(new ConstantFunction(ZERO), constantFunction.derivative());
        assertEquals(CONSTANT_STRING, constantFunction.expression());
        assertEquals(CONSTANT, constantFunction.apply(Math.random()));
    }


    @Test
    public void doSomething(){
        String function = "log(sin(x))+2*cos(x+1)+1+x/2";
        //String function = "4+18/(9-3)";
        FunctionLexer lexer = new FunctionLexer(function);
        ShuntingYardAlgorithm yardAlgorithm = new ShuntingYardAlgorithm();
        yardAlgorithm.parseTokens(lexer.tokenize());

    }
}
