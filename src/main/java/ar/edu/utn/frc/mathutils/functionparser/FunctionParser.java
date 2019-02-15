package ar.edu.utn.frc.mathutils.functionparser;

import ar.edu.utn.frc.mathutils.functionparser.lexer.lexeme.LexemeType;
import ar.edu.utn.frc.mathutils.functionparser.lexer.token.Token;

import java.util.List;

public class FunctionParser {
    public Node<Token> parse(List<Token> tokens){

        Node<Token> root = null;

        for(Token token: tokens){


            if(root == null){
                root = new Node<>(token);
            } else {


                if(token.isType(LexemeType.FUN)){
                    Node<Token> function = new Node<>(token);

                }

            }




        }
        return root;
    }
}
