package ar.edu.utn.frc.mathutils.functionparser.functionresolver;

import ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme.LexemeType;
import ar.edu.utn.frc.mathutils.functionparser.lexer.token.Token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShuntingYardAlgorithm {

    private HashMap<String, Integer> precedence;

    public ShuntingYardAlgorithm() {
        precedence = new HashMap<>();
        precedence.put("^", 1);
        precedence.put("/", 2);
        precedence.put("*", 2);
        precedence.put("+", 3);
        precedence.put("-", 3);
    }

    public void parseTokens(List<Token> tokens) {

        Stack<Token> operationsStack = new Stack<>();
        Queue<Token> outputQueue = new LinkedList<>();


        for (Token token : tokens) {
            if (token.isNumber()) {
                outputQueue.add(token);
            } else if (token.isType(LexemeType.FUN) || token.isType(LexemeType.VAR)) {
                operationsStack.push(token);
            } else if (token.isType(LexemeType.OP)) {
                if (!operationsStack.isEmpty()) {
                    Token peek = operationsStack.peek();
                    while (peek.isType(LexemeType.FUN) ||
                            (peek.isType(LexemeType.OP) &&
                                    (hasGreaterPrecedence(peek, token) || (hasEqualPrecedence(peek, token) && isLeftAssociative(peek))))) {

                        outputQueue.add(operationsStack.pop());

                        // TODO: Make this part of the code, nicer. This while is horrible!
                        if (!operationsStack.isEmpty()) {
                            peek = operationsStack.peek();
                        } else {
                            break;
                        }
                    }
                }
                operationsStack.push(token);


            } else if (token.isType(LexemeType.LP)) {
                operationsStack.push(token);
            } else if (token.isType(LexemeType.RP)) {


                if (!operationsStack.isEmpty()) {
                    Token peek = operationsStack.peek();
                    while (!peek.isType(LexemeType.LP)) {
                        outputQueue.add(operationsStack.pop());

                        // TODO: Make this part of the code, nicer. This while is horrible!
                        if (!operationsStack.isEmpty()) {
                            peek = operationsStack.peek();
                        } else {
                            break;
                        }
                    }
                }
                operationsStack.pop();
            }
        }

        while (!operationsStack.isEmpty()) {
            outputQueue.add(operationsStack.pop());
        }

        int x = 0;
    }

    private boolean isLeftAssociative(Token token) {
        return token.isType(LexemeType.OP) && token.isOneOf(Arrays.asList("+", "*", "-", "/"));
    }

    private boolean hasGreaterPrecedence(Token baseToken, Token tokenToCompare) {
        return comparePrecedence(baseToken, tokenToCompare) < 0;
    }

    private boolean hasEqualPrecedence(Token baseToken, Token tokenToCompare) {
        return comparePrecedence(baseToken, tokenToCompare) == 0;
    }

    private int comparePrecedence(Token baseToken, Token tokenToCompare) {
        String baseOperator = baseToken.getValue();
        String operatorToCompare = tokenToCompare.getValue();

        int baseOperatorOrder = precedence.get(baseOperator);
        int operatorToCompareOrder = precedence.get(operatorToCompare);
        return baseOperatorOrder - operatorToCompareOrder;
    }
}
