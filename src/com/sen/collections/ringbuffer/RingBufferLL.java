package com.sen.collections.ringbuffer;

/**
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2021/12/06
 */
public class RingBufferLL<Element> implements Queue<Element>
{
    //instance variables
    private Node<Element> head = null;
    private Node<Element> tail = null;

    // total number of elements in the buffer
    private int size = 0;

    // the default capacity of the buffer
    private static int CAPACITY = 10;

    // the operations to change size of the buffer
    private enum SIZE_OPERATION
    {
        INCREMENT,
        DECREMENT
    }

    // default constructor
    public RingBufferLL()
    {
        this(CAPACITY);
    }

    // the constructor with capacity parameter
    public RingBufferLL(int capacity)
    {
        CAPACITY = capacity;
    }

    /**
     * Inserts the element into the buffer
     *
     * @param e the e
     */
    @Override
    public void put(Element e)
    {
        // Create the new node with the element
        Node<Element> newNode = new Node<>(e);

        // Link the nodes
        if(tail != null)
        {
            // check if we have reached the end of the list secured by the capacity
            // if yes, shift the head by one position to the next item in the list
            if (size == CAPACITY)
            {
                head = head.getNext();
            }

            // set the next node of the current tail as the new node
            tail.setNext(newNode);
            // set the tail to be the new node
            tail = newNode;
        }

        // if tail is null, set the tail
        // this only happens in the beginning
        if (tail == null)
        {
            tail = newNode;
        }

        // if head is null, set the head
        // this only happens in the beginning
        if(head == null)
        {
            head = tail;
        }

        // increment the size of the buffer
        update_size(SIZE_OPERATION.INCREMENT);
    }

    /**
     * Reads the element from the buffer
     *
     * @return the element
     * @throws EmptyBufferException the empty buffer exception
     */
    @Override
    public Element get() throws EmptyBufferException
    {
        // check if the buffer is empty
        // if empty, throw the EmptyBufferException
        if (size == 0)
        {
            throw new EmptyBufferException("The buffer is empty. Please add an element before you try to get one!");
        }

        // read the element for returning at the end of the method
        Element element = head.getElement();

        // shift the head to the next available position in the buffer
        head = head.getNext();

        // decrement the size of the buffer
        update_size(SIZE_OPERATION.DECREMENT);

        return element;
    }

    /**
     * Gets the current size of the buffer
     *
     * @return the int
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Gets the capacity which was set when during the instantiation of the buffer
     *
     * @return the int
     */
    @Override
    public int capacity()
    {
        return CAPACITY;
    }

    // private methods

    /**
     * Update the size of the buffer by gracefully checking for the boundaries.
     */
    private void update_size(SIZE_OPERATION sizeOperation)
    {
        switch (sizeOperation)
        {
            case INCREMENT:
                size = size + 1;
                if (size > CAPACITY)
                {
                    size = CAPACITY;
                }
                break;
            case DECREMENT:
                size = size - 1;
                if (size < 0)
                {
                    size = 0;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        Node<Element> node = head;
        while(node != null){
            result.append(node.getElement()).append(" > ");
            node = node.getNext();
        }

        return result.toString();
    }
}
