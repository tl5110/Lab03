package rit.stu;

import rit.cs.Node;
import rit.cs.Stack;

/**
 * A stack implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the stack will hold
 * @author RIT CS
 * @author Sean Strout
 * @author Tiffany Lee
 */
public class StackNode<T> implements Stack<T> {
    /** The top element in a stack */
    Node<T> top;

    /** Create an empty stack */
    public StackNode() {
        this.top = null;
    }

    /**
     * Checks if the stack is currently empty or not
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return this.top == null;
    }

    /**
     *Remove and return the top element in the stack
     * @pre stack must not be empty
     * @throws AssertionError if stack is empty
     * @return the front element
     */
    @Override
    public T pop() {
        assert !empty();
        T og = top.getData();
        this.top = top.getNext();
        return og;
    }

    /**
     * Adds a new element to the top fo the stack
     * @param element The new data element
     */
    @Override
    public void push(T element) {
        top = new Node<>(element, top);
    }

    /**
     * Gets the top element of the stack
     * @pre stack must not be empty
     * @throws AssertionError if stack is empty
     * @return the top element
     */
    @Override
    public T top() {
        assert !empty();
        return top.getData();
    }
}