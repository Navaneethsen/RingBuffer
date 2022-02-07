package com.sen.collections.ringbuffer;

import java.util.Arrays;

/**
 * The type Ring buffer.
 *
 * @param <Element> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2021 /12/06
 */
public class RingBuffer<Element> implements Queue<Element>
{
    // instance variables
    // buffer to store elements
    private final Element[] buffer;
    // the pointer to read elements from buffer
    private int read_index = 0;
    // the pointer to write elements to buffer
    private int write_index = 0;
    // the flag to decide if we need to carry the read_index forward as write_index is trying to crossover with a new element
    private boolean carry_read_index = false;
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
    public RingBuffer()
    {
        this(CAPACITY);
    }

    // the constructor with capacity parameter
    public RingBuffer(int capacity)
    {
        buffer = (Element[]) new Object[capacity];
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
        if (e != null)
        {
            buffer[write_index] = e;

            // increment the size of the buffer as new element was added
            update_size(SIZE_OPERATION.INCREMENT);
            // update the write index to the new location to add
            write_index = update_index(write_index);

            // check if the read_index need to be carried forward with the write_index
            // this was updated in the previous put operation
            // and also there was no read operation after the previous put operation.
            // so the write_index will carry read_index with him to the next position.
            if (carry_read_index)
            {
                read_index = update_index(read_index);
                // unset the carry_read_index
                carry_read_index = false;
            }

            // the read pointer will always be behind or equal to the write_index
            // but when the write_index does a full round and tries to cross over read index, then
            // the read index need to be updated.
            // but this should be only done in the next put operation, where it makes sure that write index is trying to
            // cross over the read index
            if (write_index == read_index)
            {
                carry_read_index = true;
            }
        }
    }


    /**
     * Reads the element from the buffer
     *
     * @return the element
     */
    @Override
    public Element get() throws EmptyBufferException
    {
        // check if the object in the current index is null
        // if null, throw the EmptyBufferException
        // this will also only happen when both the read_index and write_index are at the same position
        if(write_index == read_index && buffer[read_index] == null)
        {
            throw new EmptyBufferException("The buffer is empty. Please add an element before you try to get one!");
        }

        // the write_index was trying to cross over the read_index previously, but a read operation happened and
        // the read_index automatically went ahead of the write_index.
        // So no need for the write_index to carry him in the next Put operation.
        if (carry_read_index)
        {
            carry_read_index = false;
        }

        Element element = buffer[read_index];

        // decrement the size of the buffer
        update_size(SIZE_OPERATION.DECREMENT);
        // set the position to null
        buffer[read_index] = null;
        // update the read index
        read_index = update_index(read_index);

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

    // PRIVATE METHODS

    /**
     * Update the index by checking for the buffer boundaries and gracefully jumping to the front of the queue
     *
     * @param index the index
     * @return the int
     */
    private int update_index(int index)
    {
        index = index + 1;
        if (index >= CAPACITY - 1)
        {
            index = index % CAPACITY;
        }

        return index;
    }

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
    public String toString()
    {
        return "RingBuffer{" +
                "buffer=" + Arrays.toString(buffer) +
                ", read_index=" + read_index +
                ", write_index=" + write_index +
                '}';
    }
}
