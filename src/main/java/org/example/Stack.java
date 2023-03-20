package org.example;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    List<T> items = new ArrayList<>();

    public void push(T data) {
        items.add(data);
    }

    public T pop() {
        T item = items.get(items.size()-1);
        items.remove(item);
        return item;
    }

    public boolean empty() {
        return items.size() == 0;
    }
}
