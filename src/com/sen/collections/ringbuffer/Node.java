package com.sen.collections.ringbuffer;

/**
 * The type Node.
 *
 * @param <Element> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2021 /12/06
 */
public class Node<Element>
{
    private Element element;
    private Node<Element> next;

    /**
     * Instantiates a new Node.
     *
     * @param element the element
     */
    public Node(Element element)
    {
        this.element = element;
    }

    /**
     * Gets element.
     *
     * @return the element
     */
    public Element getElement()
    {
        return element;
    }

    /**
     * Sets element.
     *
     * @param element the element
     */
    public void setElement(Element element)
    {
        this.element = element;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Node<Element> getNext()
    {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(Node<Element> next)
    {
        this.next = next;
    }

}
