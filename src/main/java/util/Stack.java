package util;

import java.util.EmptyStackException;

public class Stack<T> {

    private StackNode<T> top;

    public T pop()
    {
        if(top == null)
        {
            throw new EmptyStackException();
        }
        T data = top.getData();
        top = top.getNext();
        return data;
    }

    public void push(T t)
    {
        StackNode<T> tStackNode = new StackNode<>(t);
        if(top == null)
        {
            top = tStackNode;
        }
        else {
            StackNode<T> temp = top;
            top = tStackNode;
            top.setNext(temp);
        }
        }

    public T peek()
    {
        if(top == null)
        {
            throw new EmptyStackException();
        }
        T data = top.getData();
        return data;
    }

    public boolean isEmpty()
    {
        return top == null;
    }
}
