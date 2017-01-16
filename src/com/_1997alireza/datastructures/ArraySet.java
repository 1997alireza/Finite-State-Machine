package com._1997alireza.datastructures;

import java.util.ArrayList;

public class ArraySet<T> extends ArrayList<T>{
    @Override
    public boolean add(T t) {
        return !this.contains(t) && super.add(t);
    }
}


