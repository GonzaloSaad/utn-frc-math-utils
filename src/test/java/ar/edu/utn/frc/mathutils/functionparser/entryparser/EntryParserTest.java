package ar.edu.utn.frc.mathutils.functionparser.entryparser;


public class EntryParserTest {
    /*private static final String ENTRY_1_VALID = "A*x^2+B*log(cos(x))+C1*e^x";
    private static final String ENTRY_2_NOT_BALANCED = "A*x^2+B*log(cos(x)+C1*e^x";
    private static final String ENTRY_3_TWO_COEFFICIENTS_IN_TERM = "C*A*x^2+B*log(cos(x))+C1*e^x";
    private static final String ENTRY_4_NO_COEFFICIENTS_IN_TERM = "x^2+B*log(cos(x))+C1*e^x";
    private static final String ENTRY_5_INDEPENDENT_TERM = "A*x^2+B*log(cos(x))+C1*e^x+C2223";

    private static final String ENTRY_1_COEFFICIENT_1 = "A";
    private static final String ENTRY_1_COEFFICIENT_2 = "B";
    private static final String ENTRY_1_COEFFICIENT_3 = "C1";
    private static final String ENTRY_5_COEFFICIENT_4 = "C2223";

    private static final String ENTRY_1_FUNCTION_1 = "x^2";
    private static final String ENTRY_1_FUNCTION_2 = "log(cos(x))";
    private static final String ENTRY_1_FUNCTION_3 = "e^x";
    private static final String ENTRY_5_FUNCTION_4 = "1";

    private static final int ELEMENT_1 = 0;
    private static final int ELEMENT_2 = 1;
    private static final int ELEMENT_3 = 2;
    private static final int ELEMENT_4 = 3;


    private EntryParser entryParser;

    @Test
    public void testValidEntry() throws ParenthesesNotBalancedException, IllegalAmountOfCoefficientsInTermException {
        entryParser = new EntryParser(ENTRY_1_VALID);
        List<String> coefficients = entryParser.getConstants();
        assertEquals(ENTRY_1_COEFFICIENT_1, coefficients.get(ELEMENT_1));
        assertEquals(ENTRY_1_COEFFICIENT_2, coefficients.get(ELEMENT_2));
        assertEquals(ENTRY_1_COEFFICIENT_3, coefficients.get(ELEMENT_3));
        List<Function> functions = entryParser.getFunctions();
        assertEquals(ENTRY_1_FUNCTION_1, functions.get(ELEMENT_1).getExpression());
        assertEquals(ENTRY_1_FUNCTION_2, functions.get(ELEMENT_2).getExpression());
        assertEquals(ENTRY_1_FUNCTION_3, functions.get(ELEMENT_3).getExpression());
    }

    @Test(expected = ParenthesesNotBalancedException.class)
    public void testEntryWithUnbalancedParentheses() throws ParenthesesNotBalancedException, IllegalAmountOfCoefficientsInTermException {
        entryParser = new EntryParser(ENTRY_2_NOT_BALANCED);
    }

    @Test(expected = IllegalAmountOfCoefficientsInTermException.class)
    public void testEntryWithTwoCoefficientsInTerm() throws ParenthesesNotBalancedException, IllegalAmountOfCoefficientsInTermException {
        entryParser = new EntryParser(ENTRY_3_TWO_COEFFICIENTS_IN_TERM);
    }

    @Test(expected = IllegalAmountOfCoefficientsInTermException.class)
    public void testEntryWithNoCoefficientsInTerm() throws ParenthesesNotBalancedException, IllegalAmountOfCoefficientsInTermException {
        entryParser = new EntryParser(ENTRY_4_NO_COEFFICIENTS_IN_TERM);
    }

    @Test
    public void testEntryWithIndependentTerm() throws ParenthesesNotBalancedException, IllegalAmountOfCoefficientsInTermException {
        entryParser = new EntryParser(ENTRY_5_INDEPENDENT_TERM);
        List<String> coefficients = entryParser.getConstants();
        assertEquals(ENTRY_5_COEFFICIENT_4, coefficients.get(ELEMENT_4));
        List<Function> functions = entryParser.getFunctions();
        assertEquals(ENTRY_5_FUNCTION_4, functions.get(ELEMENT_4).getExpression());
    }*/


}
