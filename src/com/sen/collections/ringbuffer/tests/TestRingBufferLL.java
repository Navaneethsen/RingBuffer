package com.sen.collections.ringbuffer.tests;

import com.sen.collections.ringbuffer.EmptyBufferException;
import com.sen.collections.ringbuffer.RingBufferLL;

/**
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2021/12/06
 */
public class TestRingBufferLL
{
    public static void main(String[] args) throws EmptyBufferException
    {
        System.out.println("\nTesting the ArrayBased Ring Buffer");
        RingBufferLL<Integer> ringBuffer = new RingBufferLL<>(10);

        System.out.println("\nPut 6 elements [3, 0, 2, 3, 3, 8] into the buffer.");
        ringBuffer.put(3);
        ringBuffer.put(0);
        ringBuffer.put(2);
        ringBuffer.put(3);
        ringBuffer.put(3);
        ringBuffer.put(8);

        System.out.println("\nShow Buffer: <" + ringBuffer.size() + ':' + ringBuffer.capacity() + "> " + ringBuffer);

        System.out.println("\nRead 3 elements from the buffer.");
        Integer getInt = ringBuffer.get();
        System.out.println("Got " + getInt);
        getInt = ringBuffer.get();
        System.out.println("Got " + getInt);
        getInt = ringBuffer.get();
        System.out.println("Got " + getInt);

        System.out.println("\nShow Buffer: <" + ringBuffer.size() + ':' + ringBuffer.capacity() + "> " + ringBuffer);

        System.out.println("\nPut 6 elements [0, 1, 2, 0, 1, 2] into the buffer.");
        for (int i = 0; i < 2; i++)
        {
            ringBuffer.put(0);
            ringBuffer.put(1);
            ringBuffer.put(2);
        }

        System.out.println("\nShow Buffer: <" + ringBuffer.size() + ':' + ringBuffer.capacity() + "> " + ringBuffer);

        System.out.println("\nRead 9 times elements from the buffer.");
        for (int i = 0; i < 3; i++)
        {
            getInt = ringBuffer.get();
            System.out.println("Got " + getInt);
            getInt = ringBuffer.get();
            System.out.println("Got " + getInt);
            getInt = ringBuffer.get();
            System.out.println("Got " + getInt);
        }

        System.out.println("\nShow Buffer: <" + ringBuffer.size() + ':' + ringBuffer.capacity() + "> " + ringBuffer);

        try
        {
            System.out.println("\nRead 2 elements from the buffer.");
            for (int i = 0; i < 2; i++)
            {
                getInt = ringBuffer.get();
                System.out.println("Got " + getInt);
                System.out.println("\nShow Buffer: <" + ringBuffer.size() + ':' + ringBuffer.capacity() + "> " + ringBuffer);
            }
        }
        catch (EmptyBufferException emptyBufferException)
        {
            System.out.println("emptyBufferException = " + emptyBufferException.getMessage());
        }

        System.out.println("\nPut 9 elements [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] into the buffer.");
        for (int i = 0; i < 10; i++)
        {
            ringBuffer.put(i);
        }

        System.out.println("\nShow Buffer: <" + ringBuffer.size() + ':' + ringBuffer.capacity() + "> " + ringBuffer);

        try
        {
            System.out.println("\nRead 10 elements from the buffer.");
            for (int i = 0; i <= 10; i++)
            {
                getInt = ringBuffer.get();
                System.out.println("Got " + getInt);
                System.out.println("\nShow Buffer: <" + ringBuffer.size() + ':' + ringBuffer.capacity() + "> " + ringBuffer);
            }
        }
        catch (EmptyBufferException emptyBufferException)
        {
            System.out.println("emptyBufferException = " + emptyBufferException.getMessage());
        }

        long start1 = System.nanoTime();
        RingBufferLL<Integer> rb = new RingBufferLL<>(10000);
        for (int i = 0; i < rb.capacity(); i++)
        {
            rb.put(i);
        }

        for (int i = 0; i < rb.capacity(); i++)
        {
            rb.get();
        }

        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
}
