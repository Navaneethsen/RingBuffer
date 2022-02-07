package com.sen.collections.ringbuffer;

/**
 * The interface Queue.
 *
 * @param <Element> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2021 /12/06
 */
public interface Queue<Element>
{
    /**
     * Inserts the element into the buffer
     *
     * @param e the e
     */
    void put(Element e);

    /**
     * Reads the element from the buffer
     *
     * @return the element
     * @throws EmptyBufferException the empty buffer exception
     */
    Element get() throws EmptyBufferException;

    /**
     * Gets the current size of the buffer
     *
     * @return the int
     */
    int size();

    /**
     * Gets the capacity which was set when during the instantiation of the buffer
     *
     * @return the int
     */
    int capacity();

}
