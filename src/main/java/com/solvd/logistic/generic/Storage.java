package com.solvd.logistic.generic;

import com.solvd.logistic.exceptions.ShippingNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Storage <K,V>{

    private Map<K,V> storageMap;

    public Storage(){
        this.storageMap = new HashMap<>();
    }

    public void add(K key, V value){
        storageMap.put(key,value);
    }

    public boolean containsKey(K key){
        return storageMap.containsKey(key);
    }

    public V get(K key) throws ShippingNotFoundException {
        if (containsKey(key)){
            return storageMap.get(key);
        }
        throw new ShippingNotFoundException("Shipping with number "+ key + " was not found");
    }

}
