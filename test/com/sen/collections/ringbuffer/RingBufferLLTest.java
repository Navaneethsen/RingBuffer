package com.sen.collections.ringbuffer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2021/12/06
 */
public class RingBufferLLTest
{


    @Test
    public void PutAndGet() throws EmptyBufferException
    {
        RingBufferLL<Integer> ringBuffer = new RingBufferLL<Integer>();
        ringBuffer.put(3);
        ringBuffer.put(0);
        ringBuffer.put(2);
        ringBuffer.put(3);
        ringBuffer.put(3);
        ringBuffer.put(8);
        Assert.assertEquals(6, ringBuffer.size());

        Assert.assertEquals(new Integer(3), ringBuffer.get());
        Assert.assertEquals(new Integer(0), ringBuffer.get());
        Assert.assertEquals(new Integer(2), ringBuffer.get());
    }

    @Test
    public void size()
    {
    }

    @Test
    public void capacity()
    {
    }

}