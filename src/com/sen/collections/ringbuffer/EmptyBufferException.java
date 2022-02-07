package com.sen.collections.ringbuffer;

/**
 * The type Empty buffer exception.
 *
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2021 /12/06
 */
public class EmptyBufferException extends Exception
{
    /**
     * Instantiates a new Empty buffer exception.
     *
     * @param errorMessage the error message
     */
    public EmptyBufferException(String errorMessage) {
        super(errorMessage);
    }
}