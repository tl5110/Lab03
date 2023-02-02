package rit.stu;

import rit.cs.Node;
import rit.cs.Queue;
import rit.cs.QueueList;

/**
 * A queue implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the queue will hold
 * @author RIT CS
 */
public class QueueNode<T> implements Queue<T> {
    /**
     * The front/first element in the queue
     */
    Node<T> front;

    /**
     * The back/last element in the queue
     */
    Node<T> back;

    /**
     * Create an empty queue.
     */
    public QueueNode() {
        this.front = null;
        this.back = null;
    }

    /**
     * Get the last element in the queue
     * @pre queue must not be empty
     * @throws AssertionError if queue is empty
     * @return the back element
     */
    @Override
    public T back() {
        assert !empty();
        return back.getData();
    }

    /**
     * Remove and return the front element in the queue
     * @return the front element
     */
    @Override
    public T dequeue() {
        assert !empty();
        T og = front.getData();
        this.front = front.getNext();
        if(empty()){
            back = null;
        }
        return og;
    }

    /**
     * Checks if the queue is currently empty or not
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty() {
        return this.front == null;
    }

    /**
     *Add a new element to the back of the queue
     * @param element The new data element
     */
    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element, null);
        if(front == null){
            front = newNode;
        } else {
            back.setNext(newNode);
        }
        back = newNode;
    }

    /**
     * Get the front element in the queue
     * @pre queue must not be empty
     * @throws AssertionError if queue is empty
     * @return the front element
     */
    @Override
    public T front() {
        assert !empty();
        return front.getData();
    }
}
