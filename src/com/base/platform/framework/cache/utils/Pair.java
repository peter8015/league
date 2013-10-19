package com.base.platform.framework.cache.utils;

public class Pair<K, T> {
    private K key;
    private T value;
    
    
    public Pair(K key, T value) {
        this.key = key;
        this.value = value;
    }


    public K getKey() {
        return key;
    }
    

    public void setKey(K key) {
        this.key = key;
    }
    

    public T getValue() {
        return value;
    }
    

    public void setValue(T value) {
        this.value = value;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Pair other = (Pair) obj;
        if (key == null) {
            if (other.key != null) return false;
        }
        else if (!key.equals(other.key)) return false;
        if (value == null) {
            if (other.value != null) return false;
        }
        else if (!value.equals(other.value)) return false;
        return true;
    }
    

    @Override
    public String toString() {
        return "[key=" + key + ", value=" + value + "]";
    }
    
}
