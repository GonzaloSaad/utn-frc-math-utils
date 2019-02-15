package ar.edu.utn.frc.mathutils.functionparser.lexer;

import ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme.LexemeType;
import ar.edu.utn.frc.mathutils.functionparser.lexer.token.Token;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TokenTest {

    private static final LexemeType TYPE = LexemeType.FUN;
    private static final String VALUE = "()";
    private static final String VALUE_2 = "(";

    private Token token;

    @Before
    public void setUp(){
        token = new Token(TYPE, VALUE);
    }

    @Test
    public void testGetter(){
        assertEquals(TYPE, token.getType());
        assertEquals(VALUE, token.getValue());
    }

    @Test
    public void testToString(){
        assertEquals(getToStringExpected(), token.toString());
    }

    @Test
    public void testHashAndEqualsTrueCase(){
        Token equalToken = new Token(TYPE, VALUE);
        assertEquals(token, equalToken);
        assertEquals(token.hashCode(), equalToken.hashCode());
    }

    @Test
    public void testHashAndEqualsFalseCase(){
        Token notEqualToken = new Token(TYPE, VALUE_2);
        assertNotEquals(token, notEqualToken);
        assertNotEquals(token.hashCode(), notEqualToken.hashCode());
    }

    private String getToStringExpected() {
        return "Token(" + TYPE + ",'" + VALUE + "')";
    }

}
