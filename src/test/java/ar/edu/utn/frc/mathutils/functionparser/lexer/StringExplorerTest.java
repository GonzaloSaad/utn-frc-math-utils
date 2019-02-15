package ar.edu.utn.frc.mathutils.functionparser.lexer;

import ar.edu.utn.frc.mathutils.functionparser.lexer.stringexplorer.StringExplorer;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StringExplorerTest {

    private static final String INPUT = "f(x)=x^2+3";

    private StringExplorer explorer;

    @Before
    public void setUp(){
        explorer = new StringExplorer(INPUT);
    }

    @Test
    public void testGetCharInFirstMove(){
        assertEquals("f", explorer.getChar());
    }

    @Test
    public void testGetCharInSecondMove(){
        explorer.moveNext();
        assertEquals("(", explorer.getChar());
    }

    @Test
    public void testGetCharsInFirstMove(){
        assertEquals("f(", explorer.getChars(2));
    }

    @Test
    public void testGetCharsInSecondMove(){
        explorer.moveNext();
        assertEquals("(x", explorer.getChars(2));
    }

    @Test
    public void testGetCharsWithNONEResponse(){
        assertEquals(StringExplorer.NONE, explorer.getChars(INPUT.length() + 1));
    }

    @Test
    public void testHasNext(){
        assertTrue(explorer.hasNext());
        explorer.move(INPUT.length());
        assertFalse(explorer.hasNext());
        explorer.movePrev();
        assertTrue(explorer.hasNext());
    }







}
