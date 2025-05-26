package de.gothaer.container;

import java.util.ArrayList;
import java.util.List;

public class Stapel {
    private List<Object> data = new ArrayList<>();

    public Stapel(){

    }
    public void push(Object value) throws StapelException {
        if(isFull()) throw new  StapelException("Overflow");
        data.add(value);
    }

    public Object pop() throws StapelException {
        if(isEmpty()) throw new StapelException("Underflow");
        return data.remove(data.size()-1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
    public boolean isFull(){
        return false;
    }

}
