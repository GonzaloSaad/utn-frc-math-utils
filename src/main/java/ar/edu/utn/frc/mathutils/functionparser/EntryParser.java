/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frc.mathutils.functionparser;



import ar.edu.utn.frc.mathutils.functionparser.exceptions.IllegalAmountOfCoefficientsInTermException;
import ar.edu.utn.frc.mathutils.functionparser.exceptions.ParenthesesNotBalancedException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.function.Function;

/**
 * @author Gonzalo
 */
public class EntryParser {

    private final ArrayList<String> constants;
    private final ArrayList<Function> functions;

    public EntryParser(String input) throws ParenthesesNotBalancedException, IllegalAmountOfCoefficientsInTermException {
        constants = new ArrayList<>();
        functions = new ArrayList<>();
        split(input);
    }

    private void split(String input) throws ParenthesesNotBalancedException, IllegalAmountOfCoefficientsInTermException {
        ArrayList<String> terms = splitTerms(input);
        splitConstantsAndFunctions(terms);
    }

    private ArrayList<String> splitTerms(String input) throws ParenthesesNotBalancedException {
        ArrayList<String> terms = new ArrayList<>();
        int index = 0;
        int previous = 0;
        char character;

        while (index < input.length()) {
            character = input.charAt(index);
            if (character == '+') {
                terms.add(input.substring(previous, index));
                index++;
                previous = index;
            } else if (character == '(') {
                Deque<Character> q = new ArrayDeque<>();
                q.push(character);

                while (!q.isEmpty()) {
                    index++;
                    if (index >= input.length()) {
                        throw new ParenthesesNotBalancedException("Parentesis are not balanced.");
                    }
                    character = input.charAt(index);
                    if (character == '(') {
                        q.push(character);
                    } else if (character == ')') {
                        q.pop();
                    }

                }
            }
            index++;
        }
        terms.add(input.substring(previous, index));
        return terms;
    }

    private void splitConstantsAndFunctions(ArrayList<String> terms) throws IllegalAmountOfCoefficientsInTermException {
        int functionIndex = 1;
        for (String t : terms) {
            String[] factors = t.split("\\*");
            ArrayList<String> cleanFactors = new ArrayList<>();
            int coefficientCount = 0;
            for (String f : factors) {
                if (f.matches("[A-Z][0-9]*")) {
                    coefficientCount++;
                    if (coefficientCount > 1) {
                        throw new IllegalAmountOfCoefficientsInTermException("One constant isType needed per term, and only one.");
                    }
                    constants.add(f);
                } else {
                    cleanFactors.add(f);
                }
            }
            if (coefficientCount == 0) {
                throw new IllegalAmountOfCoefficientsInTermException("One constant isType needed per term.");
            }

            if (cleanFactors.size() == 0) {
                cleanFactors.add("1");
            }

            //functions.add(new Function(getFunctionExpression(functionIndex, cleanFactors)));
            functionIndex++;
        }
    }

    private String getFunctionExpression(int functionIndex, ArrayList<String> cleanFactors) {
        return "O" + functionIndex + "(x)=" + String.join("*", cleanFactors);
    }

    public ArrayList<String> getConstants() {
        return constants;
    }

    public ArrayList<Function> getFunctions() {
        return functions;
    }

    public String[] getConstantsArray() {
        return getConstants().toArray(new String[1]);
    }

    public Function[] getFunctionsArray() {
        return getFunctions().toArray(new Function[1]);
    }

}
