package com.xkcyy.collections;

import java.util.Iterator;

/**
 * @description:
 * @author: yuand
 * @date: 2019-01-27 16:02
 **/
public class RootEnumerable<T> implements Enumerable<T>  {

    private Iterable<T> source;
    protected Iterable<T> getSource(){
        return source;
    }
    public RootEnumerable(Iterable<T> source){
        this.source=source;
    }
    @Override
    public Iterator<T> iterator() {
        return source.iterator();
    }
}
