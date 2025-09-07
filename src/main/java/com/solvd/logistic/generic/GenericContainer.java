package com.solvd.logistic.generic;

public class GenericContainer<T> {
    private T item;

    public GenericContainer(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item){
        this.item = item;
    }
}
