package ar.edu.utn.frc.mathutils.functionparser;

import ar.edu.utn.frc.mathutils.functionparser.lexer.token.Token;

public class Node<T> {

    private final T data;
    private Node<T> firstChild;
    private Node<T> secondChild;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> firstChild) {
        this.data = data;
        this.firstChild = firstChild;
    }

    public Node(T data, Node<T> firstChild, Node<T> secondChild) {
        this.data = data;
        this.firstChild = firstChild;
        this.secondChild = secondChild;
    }

    public Node<T> getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(Node<T> firstChild) {
        this.firstChild = firstChild;
    }

    public Node<T> getSecondChild() {
        return secondChild;
    }

    public void setSecondChild(Node<T> secondChild) {
        this.secondChild = secondChild;
    }
}
