package ar.edu.utn.frc.mathutils.functions;

import ar.edu.utn.frc.mathutils.functions.elemental.IdentityFunction;
import ar.edu.utn.frc.mathutils.functions.operations.AddFunction;
import ar.edu.utn.frc.mathutils.functions.operations.PowerFunction;
import ar.edu.utn.frc.mathutils.functions.transcendental.trigonometric.SinFunction;
import ar.edu.utn.frc.mathutils.functions.transcendental.trigonometric.TanFunction;
import org.junit.Test;

public class BaseTest {

    @Test
    public void testBase(){
        MathFunction function = new AddFunction(new TanFunction(new SinFunction(new IdentityFunction())),
                new PowerFunction(new SinFunction(new IdentityFunction()), 6d));

        System.out.println(function.derivative().expression());
        System.out.println(function.apply(1.5));
        System.out.println(function.derivative().apply(1.5));
    }
}
